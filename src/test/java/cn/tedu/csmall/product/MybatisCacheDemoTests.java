package cn.tedu.csmall.product;

import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * 关于MyBatis缓存的个人测试
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@SpringBootTest
public class MybatisCacheDemoTests {

    // 一级缓存的演示
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testCacheOne(){
        // 创建“一个”SqlSession对象
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        AlbumMapper mapper = sqlSession1.getMapper(AlbumMapper.class);
        // 第一次查询
        AlbumStandardVO standardById1 = mapper.getStandardById(1L);
        System.out.println("一级缓存的第一次查询的结果："+standardById1);
        System.out.println("一级缓存的第一次查询的对象哈希值："+standardById1.hashCode());
        // 第二次查询
        AlbumStandardVO standardById2 = mapper.getStandardById(1L);
        System.out.println("一级缓存的第二次查询的结果："+standardById2);
        System.out.println("一级缓存的第二次查询的对象哈希值："+standardById2.hashCode());
    }

    // 二级缓存的演示
    @Test
    public void testCacheTwo() {

//        InputStream resourceAsStream;
//        try {
//            resourceAsStream = Resources.getResourceAsStream("AlbumMapper.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession(true);
//            AlbumMapper mapper = sqlSession.getMapper(AlbumMapper.class);
//            AlbumStandardVO standardById1 = mapper.getStandardById(1L);
//            System.out.println("二级缓存的第一次查询："+standardById1);
//            AlbumStandardVO standardById2 = mapper.getStandardById(1L);
//            System.out.println("二级缓存的第二次查询："+standardById2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
