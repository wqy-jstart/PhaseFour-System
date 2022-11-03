package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;

import java.util.List;

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

    /**
     * 根据id来删除属性模板数据
     * @param id id
     */
    void delete(Long id);

    /**
     * 查询属性模板的列表数据
     * @return
     */
    List<AttributeTemplateListItemVO> list();
}
