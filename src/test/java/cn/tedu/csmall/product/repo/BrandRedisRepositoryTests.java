package cn.tedu.csmall.product.repo;

import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 向Redis中写入品牌缓存的测试类
 */
@Slf4j
@SpringBootTest
public class BrandRedisRepositoryTests {

    @Autowired
    private IBrandRedisRepository repository;

    // 测试调用实现类存入品牌对象数据
    @Test
    void save(){
        BrandStandardVO brandStandardVO = new BrandStandardVO();
        brandStandardVO.setId(1L);
        brandStandardVO.setName("缓存品牌1");
        repository.save(brandStandardVO);

        brandStandardVO.setId(2L);
        brandStandardVO.setName("缓存品牌2");
        repository.save(brandStandardVO);

        brandStandardVO.setId(3L);
        brandStandardVO.setName("缓存品牌4");
        repository.save(brandStandardVO);

        brandStandardVO.setId(4L);
        brandStandardVO.setName("缓存品牌4");
        repository.save(brandStandardVO);

        brandStandardVO.setId(5L);
        brandStandardVO.setName("缓存品牌5");
        repository.save(brandStandardVO);

        log.debug("向Redis缓存中写入数据，完成！");
    }

    // 测试调用实现类存放品牌列表
    @Test
    void saveList(){
        // 准备一个品牌列表
        List<BrandListItemVO> brands = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BrandListItemVO brand = new BrandListItemVO();
            brand.setId(i + 0L);
            brand.setName("测试缓存品牌"+i);
            brands.add(brand);
        }

        repository.save(brands);
        log.debug("向Redis缓存中写入列表数据，完成！");
    }

    // 测试删除Redis中所有数据
    @Test
    void deleteAll(){
        Long count = repository.deleteAll();
        log.debug("删除Redis缓存中所有品牌数据，删除的数据的数量：{}", count);
    }

    // 测试调用实现类取出品牌对象数据
    @Test
    void get(){
        Long id = 1L;
        BrandStandardVO queryResult = repository.get(id);
        log.debug("根据数据ID【{}】从Redis缓存中读取数据，结果：{}", id, queryResult);
    }

    // 测试调用实现类获取存入的品牌列表
    @Test
    void getList(){
        List<BrandListItemVO> list = repository.list();
        log.debug("从Redis缓存中读取列表数据，列表的长度：{}", list.size());
        for (BrandListItemVO brand : list) {
            log.debug("列表项:{}",brand);
        }
    }

    // 测试调用实现类按照下标获取品牌列表数据
    @Test
    void getListRange(){
        long start = 2;
        long end = 7;
        List<BrandListItemVO> list = repository.list(start,end);
        log.debug("从Redis缓存中读取列表中从下标【{}】到下标【{}】的数据，列表的长度：{}",
                start, end, list.size());
        for (BrandListItemVO brand : list) {
            log.debug("列表项:{}",brand);
        }
    }
}
