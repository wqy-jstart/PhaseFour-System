package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.CategoryAttributeTemplateAddNewDTO;

/**
 * 创建类别与属性模板的Service接口
 *
 * @Author java@.Wqy
 * @Version 0.0.1
 */
public interface ICategoryAttributeTemplateService {

    /**
     * 添加菜单属性
     * @param categoryAttributeAddNewDTO
     */
    void addNew(CategoryAttributeTemplateAddNewDTO categoryAttributeAddNewDTO);
}
