package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.CategoryAttributeTemplateMapper;
import cn.tedu.csmall.product.pojo.dto.CategoryAttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.CategoryAttributeTemplate;
import cn.tedu.csmall.product.service.ICategoryAttributeTemplateService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建类别与属性模板的实现类
 *
 * @Author java@.Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class CategoryAttributeTemplateServiceImpl implements ICategoryAttributeTemplateService {

    @Autowired
    CategoryAttributeTemplateMapper categoryAttributeTemplateMapper;

    public CategoryAttributeTemplateServiceImpl(){
        log.debug("创建业务对象:CategoryAttributeTemplateServiceImpl");
    }

    @Override
    public void addNew(CategoryAttributeTemplateAddNewDTO categoryAttributeTemplateAddNewDTO) {
        log.debug("开始处理[类别与属性模板]的业务,参数:{}",categoryAttributeTemplateAddNewDTO);

        Long categoryId = categoryAttributeTemplateAddNewDTO.getCategoryId();
        log.debug("检查类别与属性模板的类别Id是否被占用");
        int count = categoryAttributeTemplateMapper.countByCategoryId(categoryId);
        if (count>0){
            String message = "添加分类与属性模板信息失败,id已经被占用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        log.debug("该分类与属性模板没有被占用,即将进行插入");
        CategoryAttributeTemplate categoryAttributeTemplate = new CategoryAttributeTemplate();
        BeanUtils.copyProperties(categoryAttributeTemplateAddNewDTO,categoryAttributeTemplate);
        log.debug("开始执行插入数据");
        categoryAttributeTemplateMapper.insert(categoryAttributeTemplate);
        log.debug("添加数据成功!");
    }

}
