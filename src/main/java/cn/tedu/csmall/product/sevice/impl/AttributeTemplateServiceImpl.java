package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AttributeTemplateMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.sevice.IAttributeTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 属性模板接口的实现类
 *
 * @Author Wqy
 * Version 0.0.1
 */
@Slf4j
@Service
public class AttributeTemplateServiceImpl implements IAttributeTemplateService {

    @Autowired
    AttributeTemplateMapper attributeTemplateMapper;

    public AttributeTemplateServiceImpl(){
        log.debug("创建业务对象:AttributeTemplateServiceImpl");
    }

    @Override
    public void addNew(AttributeTemplateNewDTO attributeTemplateNewDTO) {
        log.debug("开始处理[属性模板]的业务,参数{}",attributeTemplateNewDTO);

        String attributeTemplateName = attributeTemplateNewDTO.getName();
        log.debug("检查品牌名称是否已经被占用");
        int count = attributeTemplateMapper.countByName(attributeTemplateName);
        if (count>0){
           String message = "添加属性模板信息失败,名称已经被占用!";
           log.debug(message);
            throw new ServiceException(message);
        }
        log.debug("该属性模板名称没有占用,即将向属性模板表中插入数据");
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        BeanUtils.copyProperties(attributeTemplateNewDTO,attributeTemplate);//将前者传入的信息复制到后者属性模板实体类信息中
        log.debug("开始执行插入数据!");
        attributeTemplateMapper.insert(attributeTemplate);
        log.debug("添加数据成功!");
    }
}
