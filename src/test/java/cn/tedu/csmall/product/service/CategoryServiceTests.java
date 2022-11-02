package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.sevice.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    ICategoryService categoryService;

    @Test
    void addNew(){
        CategoryAddNewDTO categoryAddNewDTO = new CategoryAddNewDTO();
        categoryAddNewDTO.setName("橘子");
        categoryAddNewDTO.setParentId(880L);
        categoryAddNewDTO.setKeywords("无");
        categoryAddNewDTO.setSort(2);
        categoryAddNewDTO.setIcon("无");
        categoryAddNewDTO.setEnable(1);
        categoryAddNewDTO.setIsDisplay(1);
        try{
            categoryService.addNew(categoryAddNewDTO);
            log.debug("测试添加数据成功!");
        }catch (ServiceException e){
            log.debug(e.getMessage());//捕获异常时输出
        }
    }
}
