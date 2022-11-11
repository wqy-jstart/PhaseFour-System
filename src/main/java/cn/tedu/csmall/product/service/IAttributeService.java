package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;

import java.util.List;

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

    /**
     * 根据id删除模板
     * @param id 要删除的模板id
     */
    void delete(Long id);

    /**
     * 根据id修改属性模板
     * @param attribute attribute
     */
    void update(Attribute attribute);

    /**
     * 查询所有属性列表的数据
     * @return List
     */
    List<AttributeListItemVO> list();

    /**
     * 根据id查询属性详情
     * @param id 属性id
     * @return 返回属性详情的VO类
     */
    AttributeStandardVO selectById(Long id);
}
