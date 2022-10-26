package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;

/**
 * 创建属性模板的接口
 *
 * @Author Wqy
 * @Version 0.0.1
 */
public interface IAttributeTemplateService {

    /**
     * 该方法用来执行添加属性模板的数据
     */
    void addNew(AttributeTemplateNewDTO attributeTemplateNewDTO);
}
