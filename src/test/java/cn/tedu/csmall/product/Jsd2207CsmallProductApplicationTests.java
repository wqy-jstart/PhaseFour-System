package cn.tedu.csmall.product;

import cn.tedu.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class Jsd2207CsmallProductApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Hello World!");
    }

    @Autowired
    DataSource dataSource;

    @Test
    void getConnection() throws Throwable {
        dataSource.getConnection();
    }

    @Test
    void f1(){

    }
}
