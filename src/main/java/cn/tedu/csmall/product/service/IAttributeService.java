package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AttributeUpdateInfoDTO;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理属性的接口
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Transactional
public interface IAttributeService {
    /**
     * 添加属性
     *
     * @param attributeAddNewDTO 需要添加的属性DTO类
     */
    void addNew(AttributeAddNewDTO attributeAddNewDTO);

    /**
     * 根据id删除模板
     * @param id 要删除的模板id
     */
    void delete(Long id);

    /**
     * 修改属性基本资料
     *
     * @param id                     属性id
     * @param attributeUpdateInfoDTO 封装了新基本资料的对象
     */
    void updateInfoById(Long id, AttributeUpdateInfoDTO attributeUpdateInfoDTO);

    /**
     * 根据id查询属性详情
     * @param id 属性id
     * @return 返回属性详情的VO类
     */
    AttributeStandardVO selectById(Long id);

    /**
     * 查询所有属性列表的数据
     * @return List
     */
    List<AttributeListItemVO> list();

    /**
     * 根据模板id查询属性数据
     * @param templateId 模板id
     * @return 返回查询的属性数据List集合
     */
    List<AttributeListItemVO> listByTemplate(Long templateId);

}
