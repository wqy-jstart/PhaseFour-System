package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AttributeMapper;
import cn.tedu.csmall.product.mapper.AttributeTemplateMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.tedu.csmall.product.service.IAttributeService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private AttributeTemplateMapper attributeTemplateMapper;

    public AttributeServiceImpl(){
        log.debug("创建业务对象:AttributeServiceImpl");
    }

    /**
     * 处理添加属性的业务
     * @param attributeAddNewDTO 客户端传递的属性的信息
     */
    @Override
    public void addNew(AttributeAddNewDTO attributeAddNewDTO) {
        log.debug("开始处理[添加属性]的业务,参数{}",attributeAddNewDTO);
        // 从参数对象中获取属性名称
        Long templateId = attributeAddNewDTO.getTemplateId();
        String templateName = attributeAddNewDTO.getName();
        // 检查属性名称是否已经被占用(属性表中是否已经存在该name)
        log.debug("检查属性名称是否已经被占用");
        int count = attributeMapper.countByNameAndTemplateId(templateName,templateId);
        if (count>0){
            String message = "添加属性失败,在同一属性模板下,属性名称必须唯一";
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

    /**
     * 处理删除模板的业务
     * @param id 要删除的模板id
     */
    @Override
    public void delete(Long id) {
        // TODO 删除模板的业务
    }

    /**
     * 根据id修改属性数据
     * @param attribute attribute
     */
    @Override
    public void update(Attribute attribute) {
        log.debug("开始处理[根据id修改属性数据]的业务,参数{}",attribute.getId());
        // 根据属性id查询是否含有该属性的信息
        AttributeStandardVO attributeStandardVO = attributeMapper.getStandardById(attribute.getId());
        if (attributeStandardVO==null){
            String message = "修改失败,该属性id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }

        // 查询属性名称与该属性id对应的模板id是否存在
        int count = attributeMapper.countByNameAndTemplateId(attribute.getName(),attributeStandardVO.getTemplateId());
        if (count!=0){
            String message = "修改失败,该属性名称与模板id已经存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }

        int rows = attributeMapper.update(attribute);
        if (rows>1){
            String message = "修改失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }
    }

    /**
     * 根据id查询属性详情
     * @param id 属性id
     * @return 返回属性详情的VO类
     */
    @Override
    public AttributeStandardVO selectById(Long id) {
        log.debug("开始处理[根据id查询属性详情]的业务");
        AttributeStandardVO attributeStandardVO =  attributeMapper.getStandardById(id);
        if (attributeStandardVO==null){
            String message = "查询失败,该id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_SELECT,message);
        }
        return attributeStandardVO;
    }

    /**
     * 处理属性列表数据的业务
     * @return 返回List
     */
    @Override
    public List<AttributeListItemVO> list() {
        log.debug("开始处理查询[属性列表的业务]");
        return attributeMapper.list();
    }

    /**
     * 根据模板id查询属性列表
     * @param templateId 模板id
     * @return 返回属性列表的List集合
     */
    @Override
    public List<AttributeListItemVO> listByTemplate(Long templateId) {
        log.debug("开始处理[根据模板id查询属性数据]的业务,参数:{}",templateId);
        AttributeTemplateStandardVO attributeTemplateStandardVO = attributeTemplateMapper.getStandardById(templateId);
        if (attributeTemplateStandardVO==null){
            String message = "查询失败,该模板id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_SELECT,message);
        }

        int count = attributeMapper.countByTemplateId(templateId);
        if (count==0){
            String message = "查询失败,该模板下的数据不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_SELECT,message);
        }
        return attributeMapper.listByTemplateId(templateId);
    }
}
