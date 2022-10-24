package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandMapperTests {

    @Autowired
    BrandMapper mapper;

    @Test
    void insert(){
        Brand brand = new Brand();
        brand.setName("格力");//商品名称
        brand.setPinyin("GeLi");//商品拼音
        brand.setLogo("GL");//商品标志
        brand.setDescription("该商品非常好!");//商品描述
        brand.setKeywords("格");
        brand.setSort(1);
        brand.setSales(3000);
        brand.setProductCount(30);
        brand.setCommentCount(300);
        brand.setPositiveCommentCount(200);
        brand.setEnable(1);
        int rows = mapper.insert(brand);
        System.out.println("影响的条数为:"+rows);
    }
}
