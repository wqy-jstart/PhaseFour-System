package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AttributeMapper;
import cn.tedu.csmall.product.mapper.AttributeTemplateMapper;
import cn.tedu.csmall.product.mapper.CategoryAttributeTemplateMapper;
import cn.tedu.csmall.product.mapper.SpuMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    AttributeMapper attributeMapper;

    @Autowired
    CategoryAttributeTemplateMapper categoryAttributeTemplateMapper;

    @Autowired
    SpuMapper spuMapper;

    public AttributeTemplateServiceImpl() {
        log.debug("创建业务对象:AttributeTemplateServiceImpl");
    }

    @Override
    public void addNew(AttributeTemplateNewDTO attributeTemplateNewDTO) {
        log.debug("开始处理[属性模板]的业务,参数{}", attributeTemplateNewDTO);

        String attributeTemplateName = attributeTemplateNewDTO.getName();
        log.debug("检查品牌名称是否已经被占用");
        int count = attributeTemplateMapper.countByName(attributeTemplateName);
        if (count > 0) {
            String message = "添加属性模板信息失败,名称已经被占用!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        log.debug("该属性模板名称没有占用,即将向属性模板表中插入数据");
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        BeanUtils.copyProperties(attributeTemplateNewDTO, attributeTemplate);//将前者传入的信息复制到后者属性模板实体类信息中
        log.debug("开始执行插入数据!");
        int rows = attributeTemplateMapper.insert(attributeTemplate);
        if (rows != 1){// 如果插入所影响的行数不为1
            String message = "添加属性模板失败,服务器忙,请稍后再尝试!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
        log.debug("添加数据成功!");
    }

    /**
     * 处理根据id删除属性模板的业务
     *
     * @param id id
     */
    @Override
    public void delete(Long id) {
        log.debug("开始处理[根据id{}删除属性模板]的业务", id);

        AttributeTemplateStandardVO queryResult = attributeTemplateMapper.getStandardById(id);
        if (queryResult == null) {
            String message = "删除属性模板失败，尝试访问的数据不存在！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 检查是否存在属性关联到此属性模板,如果存在,则不允许删除
        {
            int count = attributeMapper.countByTemplateId(id);
            if (count > 0) {
                String message = "删除属性模板失败,此属性模板存在关联的属性数据";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        // 检查是否存在分类属性模版数据关联到此属性模板,如果存在,则不允许删除
        {
            int count = categoryAttributeTemplateMapper.countByAttributeTemplateId(id);
            if (count > 0) {
                String message = "删除属性模板失败,此属性模板存在关联的分类属性模版数据";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        // 检查是否存在SPU关联到此属性模板,如果存在,则不允许删除
        {
            int count = spuMapper.countByAttributeTemplateId(id);
            if (count > 0) {
                String message = "删除属性模板失败,此属性模板存在关联的SPU数据";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        log.debug("开始执行删除属性模板数据");
        int rows = attributeTemplateMapper.deleteById(id);
        if (rows != 1){// 如果插入所影响的行数不为1
            String message = "删除属性模板失败,服务器忙,请稍后再尝试!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }
        log.debug("删除属性模板数据完成!");
    }

    /**
     * 处理属性模板的列表业务
     *
     * @return List
     */
    @Override
    public List<AttributeTemplateListItemVO> list() {
        log.debug("开始处理[属性模板列表]的功能");
        return attributeTemplateMapper.list();
    }
}
