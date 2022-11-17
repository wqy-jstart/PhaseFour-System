package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    ICategoryService categoryService;

    @Test
    void addNew(){
        CategoryAddNewDTO categoryAddNewDTO = new CategoryAddNewDTO();
        categoryAddNewDTO.setName("s橘");
        categoryAddNewDTO.setParentId(93L);
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

    @Test
    void enable(){
        try {
            Long id = 2L;
//        categoryService.setEnable(id);
//        categoryService.setDisable(id);
            categoryService.setDisplay(id);
//        categoryService.setHidden(id);
        }catch (RuntimeException e){
            log.debug(e.getMessage());
        }

    }

    @Test
    void selectById(){
        Long id = 1L;
        CategoryStandardVO categoryStandardVO = categoryService.selectById(id);
        log.debug("id为{}的类别详情为:{}",id,categoryStandardVO);
    }

    @Test
    void selectByParentId(){
        Long id = 1L;
        List<CategoryListItemVO> list = categoryService.listByParentId(id);
        for (CategoryListItemVO item : list) {
            log.debug("{}",item);
        }
    }
}
