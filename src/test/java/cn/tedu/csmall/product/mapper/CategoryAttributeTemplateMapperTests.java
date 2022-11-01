package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CategoryAttributeTemplateMapperTests {

    @Autowired
    CategoryAttributeTemplateMapper categoryAttributeTemplateMapper;

    @Test
    void selectAttributeTemplateId(){
        Long id = 2L;
        try {
            int count = categoryAttributeTemplateMapper.countByAttributeTemplateId(id);
            log.debug("查询成功,查询的数据数量为{}",count);
        }catch (ServiceException e){
            log.debug(e.getMessage());
        }
    }
}
