package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AttributeServiceTests {

    @Autowired
    private IAttributeService attributeService;

    @Test
    void selectById(){
        Long id = 1L;
        AttributeStandardVO attributeStandardVO = attributeService.selectById(id);
        log.debug("查询id为{}的属性详情,参数:{}",id,attributeStandardVO);
    }
}
