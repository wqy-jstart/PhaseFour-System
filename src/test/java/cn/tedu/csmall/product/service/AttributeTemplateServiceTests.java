package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
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
    @Test
    void selectById(){
        Long id = 4L;
        AttributeTemplateStandardVO attributeTemplateStandardVO = attributeTemplateService.selectById(id);
        log.debug("查询id为{}的属性模板详情,参数为:{}",id,attributeTemplateStandardVO);
    }
}
