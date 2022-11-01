package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AttributeMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.sevice.IAttributeService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现属性接口的实现类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class AttributeServiceImpl implements IAttributeService {

    @Autowired
    private AttributeMapper attributeMapper;

    public AttributeServiceImpl(){
        log.debug("创建业务对象:AttributeServiceImpl");
    }

    @Override
    public void addNew(AttributeAddNewDTO attributeAddNewDTO) {
        log.debug("开始处理[添加属性]的业务,参数{}",attributeAddNewDTO);
        // 从参数对象中获取属性名称
        Long templateId = attributeAddNewDTO.getTemplateId();
        // 检查属性名称是否已经被占用(属性表中是否已经存在该name)
        log.debug("检查属性名称是否已经被占用");
        int count = attributeMapper.countByTemplateId(templateId);
        if (count>0){
            String message = "添加属性失败,相册名称已经被占用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        log.debug("相册名称没有被占用,即将向属性表中插入数据");
        Attribute attribute = new Attribute();
        BeanUtils.copyProperties(attributeAddNewDTO,attribute);
        log.debug("即将插入属性数据:{}",attribute);
        attributeMapper.insert(attribute);
        log.debug("插入属性数据完成");
    }
}
