package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;

/**
 * 处理属性的接口
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
public interface IAttributeService {
    /**
     * 添加属性
     *
     * @param attributeAddNewDTO
     */
    void addNew(AttributeAddNewDTO attributeAddNewDTO);
}
