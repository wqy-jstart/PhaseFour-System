package cn.tedu.csmall.product;

import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MybatisCacheTests {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    // Mybatis一级缓存演示
    @Test
    void l1Cache(){
        // 一级缓存必须保证多次的查询操作满足：同一个SqlSession、同一个Mapper、执行相同的SQL查询、使用相同的参数。
        SqlSession sqlsession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);
        // 第一次查询后,因缓存原因,第二次执行同一个Mapper时会使用同一个对象,且不会执行查操作
        Long id = 1L;
        log.debug("开始第【1】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result1 = brandMapper.getStandardById(id);
        log.debug("第【1】查询结果的hashCode()值为：{}", result1.hashCode());
        log.debug("开始第【2】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result2 = brandMapper.getStandardById(id);
        log.debug("第【2】查询结果的hashCode()值为：{}", result2.hashCode());

        log.debug("第【1】次的查询结果与第【2】的查询结果进行对比，结果：{}", result1 == result2);

        id = 2L;
        log.debug("开始第【1】次执行根据ID【2】查询品牌详情……");
        BrandStandardVO result3 = brandMapper.getStandardById(id);
        log.debug("第【1】查询结果的hashCode()值为：{}", result3.hashCode());
        log.debug("开始第【2】次执行根据ID【2】查询品牌详情……");
        BrandStandardVO result4 = brandMapper.getStandardById(id);
        log.debug("第【2】查询结果的hashCode()值为：{}", result4.hashCode());

        // log.debug("即将调用SqlSession对象的clearCache()方法清除缓存……");
        // sqlSession.clearCache();// 这是用来清除一级缓存的方法之一
        // log.debug("已经清除以前产生的缓存数据！");

        log.debug("即将执行写操作……");// 当执行了写操作(增/删/改),无论任何数据有没有变化,都会清空此前产生的缓存
        Brand brand = new Brand();
        brand.setId(6L);
        brand.setName("微软2022");
        brandMapper.update(brand);
        log.debug("执行写操作，完成！");

        // 当清除了缓存之后,即可重新查询Mapper数据,相当于第一次查询,但再次查询还是会存在缓存
        id = 1L;
        log.debug("开始第【3】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result5 = brandMapper.getStandardById(id);
        log.debug("第【3】查询结果的hashCode()值为：{}", result5.hashCode());

        id = 2L;
        log.debug("开始第【3】次执行根据ID【2】查询品牌详情……");
        BrandStandardVO result6 = brandMapper.getStandardById(id);
        log.debug("第【3】查询结果的hashCode()值为：{}", result6.hashCode());
    }

    @Autowired
    BrandMapper brandMapper;

    // Mybatis二级缓存演示
    @Test
    void l2Cache() {
        // 只要执行的是相同的Mapper的查询，且查询参数相同，就可以应用二级缓存。
        Long id = 1L;
        log.debug("开始第【1】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result1 = brandMapper.getStandardById(id);
        log.debug("第【1】查询结果的hashCode()值为：{}", result1.hashCode());

        log.debug("开始第【2】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result2 = brandMapper.getStandardById(id);
        log.debug("第【2】查询结果的hashCode()值为：{}", result2.hashCode());

        log.debug("即将执行写操作……");
        Brand brand = new Brand();
        brand.setId(6L);
        brand.setName("微软2022");
        brandMapper.update(brand);
        log.debug("执行写操作，完成！");

        log.debug("开始第【3】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result3 = brandMapper.getStandardById(id);
        log.debug("第【3】查询结果的hashCode()值为：{}", result3.hashCode());

        log.debug("开始第【4】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result4 = brandMapper.getStandardById(id);
        log.debug("第【4】查询结果的hashCode()值为：{}", result4.hashCode());

        log.debug("开始第【5】次执行根据ID【1】查询品牌详情……");
        BrandStandardVO result5 = brandMapper.getStandardById(id);
        log.debug("第【5】查询结果的hashCode()值为：{}", result5.hashCode());
    }
}
