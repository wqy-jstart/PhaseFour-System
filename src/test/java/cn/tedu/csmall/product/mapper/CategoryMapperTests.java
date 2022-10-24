package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryMapperTests {

    @Autowired
    CategoryMapper mapper;

    @Test
    void insert(){
        Category category = new Category();
        category.setName("品牌男装");
        category.setParentId(1L);
        category.setDepth(2);
        category.setKeywords("无");
        category.setSort(2);
        category.setIcon("无");
        category.setEnable(1);
        category.setIsParent(1);
        category.setIsDisplay(1);

        int rows = mapper.insert(category);
        System.out.println("影响的条数为:"+rows);
    }
}
