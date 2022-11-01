package cn.tedu.csmall.product.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BrandCategoryMapperTests {

    @Autowired
    BrandCategoryMapper brandCategoryMapper;

    @Test
    void selectByBrandId(){
        Long id = 22L;
        int count = brandCategoryMapper.countByBrandId(id);
        log.debug("查询成功,查询到{}条数据",count);
    }
}
