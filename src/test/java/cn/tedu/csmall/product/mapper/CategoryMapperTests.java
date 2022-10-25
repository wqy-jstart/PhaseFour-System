package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class CategoryMapperTests {

    @Autowired
    CategoryMapper mapper;

    //插入
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

    //批量插入
    @Test
    void insertBatch(){
        List<Category> categories = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Category category = new Category();
            category.setName("品牌男装"+i);
            category.setParentId(1L);
            category.setDepth(2);
            category.setKeywords("无"+i);
            category.setSort(2);
            category.setIcon("无"+i);
            category.setEnable(1);
            category.setIsParent(1);
            category.setIsDisplay(1);
            categories.add(category);
        }
        int rows = mapper.insertBatch(categories);
        log.debug("批量插入完成,影响数据的条数为{}",rows);
    }

    //删除
    @Test
    void deleteById(){
        int rows = mapper.deleteById(79L);
        log.debug("删除完成,影响数据的条数为{}",rows);
    }

    //批量删除
    @Test
    void deleteByIds(){
        Long[] ids = {76L,77L,78L};
        int rows = mapper.deleteByIds(ids);
        log.debug("批量删除完成,影响的数据条数为:{}",rows);
    }
}
