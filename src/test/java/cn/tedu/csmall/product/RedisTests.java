package cn.tedu.csmall.product;

import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.repo.IBrandRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootTest
public class RedisTests {

    @Autowired
    RedisTemplate<String , Serializable> redisTemplate;

    // Redis编程相关API
    // =====================
    // 【RedisTemplate类】
    // ValueOperations opsForValue() >>> 获取ValueOperations对象，操作Redis中的string类型时需要此对象
    // ListOperations opsForList() >>> 获取ListOperations对象，操作Redis中的list类型时需要此对象
    // Set<String> keys(String pattern) >>> 根据模式pattern搜索Key
    // Boolean delete(String key) >>> 根据Key删除数据，返回成功与否
    // Long delete(Collection<String> keys) >>> 根据Key的集合批量删除数据，返回成功删除的数据的数量
    //
    // 【ValueOperations类】
    // void set(String key, Serializable value) >>> 向Redis中写入数据
    // Serializable get(String key) >>> 读取Redis中的数据

    // 向Redis中存入数据
    @Test
    void valueSet(){
        String key = "username";
        String value = "fanchaunqi";

        ValueOperations<String ,Serializable> ops = redisTemplate.opsForValue();
        ops.set(key,value);
    }

    // 向Redis中存入对象
    @Test
    void valueSetObject(){
        String key = "album2022";
        AlbumStandardVO album = new AlbumStandardVO();
        album.setId(2022L);
        album.setName("测试相册00001");
        album.setDescription("测试简介00001");
        album.setSort(998);

        ValueOperations<String,Serializable> ops = redisTemplate.opsForValue();
        ops.set(key,album);
    }

    // 向Redis中取出数据
    @Test
    void valueGet(){
        String key = "username";

        ValueOperations<String ,Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("从Redis中取出Key值为[{}]的数据,结果:{}",key,value);
    }

    // 向Redis中取出对象
    @Test
    void valueGetObject(){
        String key = "album2022";

        ValueOperations<String,Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("从Redis中取出Key值为[{}]的数据",key);
        log.debug("结果:{}",value);
        log.debug("结果的数据类型:{}",value.getClass().getName());
    }

    // 根据正则查询数据
    @Test
    void keys(){
        String pattern = "*";

        Set<String> keys = redisTemplate.keys(pattern);
        log.debug("根据模式[{}]搜索Key,结果:{}",pattern,keys);
    }

    // 删除一条Redis数据
    @Test
    void delete(){
        String key = "username1";

        Boolean result = redisTemplate.delete(key);
        log.debug("根据key[{}]删除数据完成,结果为:{}",key,result);
    }

    // 删除多条Redis数据
    @Test
    void deleteX(){
        Set<String> keys = new HashSet<>();
        keys.add("username2");
        keys.add("username3");
        keys.add("username4");

        Long count = redisTemplate.delete(keys);
        log.debug("根据Key集合[{}]删除数据完成,成功删除的数据的数量:{}",keys,count);
    }

    // 存放一个Key为"stringList"的集合,通常左侧压栈
    @Test
    public void rightPush(){
        String key = "stringList";
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            stringList.add("string-"+i);
        }

        ListOperations<String,Serializable> ops = redisTemplate.opsForList();
        for (String s : stringList) {
            ops.rightPush(key,s);
        }
    }

    // 查询Redis中"stringList"的长度
    @Test
    public void selectList(){
        String key = "stringList";
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        Long size = ops.size(key);
        log.debug("集合{}中的长度为:{}",key,size);
    }

    // 读取部分"stringList"中的元素(不能倒着读)
    // 0 ~~~ list.size()-1 正向下标
    // -list.size() ~~~ -1 反向下标
    @Test
    public void range(){
        String key = "stringList";
        long start = 0;
        long end = -1;

        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        List<Serializable> list = ops.range(key, start, end);
        log.debug("根据Key[{}]从[{}]到[{}]读取列表,结果长度为:{}",key,start,end,list.size());
        for (Serializable item : list) {
            log.debug("列表项:{}",item);
        }
    }

    // 向Redis中用Set集合(不可重复)存储品牌的key值
    @Test
    void add(){
        SetOperations<String, Serializable> ops = redisTemplate.opsForSet();
        String key = "brandKeys";
//        String value = "brand:item1";
        for (int i = 1; i <= 5; i++) {
            String value = IBrandRedisRepository.BRAND_ITEM_KEY_PREFIX+i;
            ops.add(key,value);
        }
//        ops.add(key,value);
        log.debug("添加完成!");
    }

    // 获取Redis中保存在Set集合中的key值
    @Test
    void members(){
        SetOperations<String, Serializable> ops = redisTemplate.opsForSet();
        String key = "brandKeys";
        Set<Serializable> members = ops.members(key);
        log.debug("根据Key[{}]读取Set数据,结果:{}",key,members);
    }
}
