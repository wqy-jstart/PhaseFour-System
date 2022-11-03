package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j//该注解用来输出日志
@SpringBootTest
public class AttributeTemplateServiceTests {

    @Autowired
    IAttributeTemplateService attributeTemplateService;

    @Test
    void addNew(){
        AttributeTemplateNewDTO attributeTemplateNewDTO = new AttributeTemplateNewDTO();
        attributeTemplateNewDTO.setName("不知道6");
        attributeTemplateNewDTO.setPinyin("buzd");
        attributeTemplateNewDTO.setKeywords("无");
        attributeTemplateNewDTO.setSort(1);
        try{
            attributeTemplateService.addNew(attributeTemplateNewDTO);
            log.debug("测试添加数据成功!");
        }catch (ServiceException e){
            log.debug(e.getMessage());
        }
    }
}
