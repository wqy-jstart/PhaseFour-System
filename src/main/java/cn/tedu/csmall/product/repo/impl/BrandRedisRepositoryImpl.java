package cn.tedu.csmall.product.repo.impl;

import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.repo.IBrandRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理Redis中品牌缓存的实现类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Repository// 声明一个组件
public class BrandRedisRepositoryImpl implements IBrandRedisRepository {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    public BrandRedisRepositoryImpl(){
        log.debug("创建处理缓存的数据访问对象:BrandRedisRepositoryImpl");
    }

    // 向Redis中写入数据
    @Override
    public void save(BrandStandardVO brandStandardVO) {
        String key = BRAND_ITEM_KEY_PREFIX+brandStandardVO.getId();// 这样存储便于在Redis中归类呈现
        redisTemplate.opsForValue().set(key,brandStandardVO);
    }

    // 向Redis中写入多条品牌数据
    @Override
    public void save(List<BrandListItemVO> brands) {
        String key = BRAND_LIST_KEY;// 用来存放品牌列表的key
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();// 获取ListOperations
        for (BrandListItemVO brand : brands) {
            ops.rightPush(key,brand);// 调用方法向Redis中存入品牌列表
        }
    }

    // 根据key向Redis中获取一条品牌数据
    @Override
    public BrandStandardVO get(Long id) {
        Serializable serializable = redisTemplate.opsForValue().get(BRAND_ITEM_KEY_PREFIX+id);
        BrandStandardVO brandStandardVO = null;
        if (serializable!=null){
            if (serializable instanceof BrandStandardVO){
                brandStandardVO = (BrandStandardVO) serializable;
            }
        }
        return brandStandardVO;
    }

    // 向Redis中查询所有品牌列表
    @Override
    public List<BrandListItemVO> list() {
        long start = 0;
        long end = -1;
        return list(start,end);// 调用list()方法传入起始和末尾下标,返回所有品牌列表
    }

    // 根据下标向Redis中获取品牌数据
    @Override
    public List<BrandListItemVO> list(long start, long end) {
        String key = BRAND_LIST_KEY;// 品牌列表的key值
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();// 获取ListOperations
        List<Serializable> list = ops.range(key, start, end);// 调方法传下标,返回指定下标范围的品牌数据
        List<BrandListItemVO> brands = new ArrayList<>();// 创建一个List集合
        for (Serializable item : list) {// 遍历获取的指定下标范围的品牌数据
            brands.add((BrandListItemVO) item);// 放到List集合中
        }
        return brands;// 作出返回
    }
}
