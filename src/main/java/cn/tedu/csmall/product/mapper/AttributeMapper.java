package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建属性的Mapper接口,建立DAO层
 */
@Repository
public interface AttributeMapper {

    int insert(Attribute attribute);

    int insertBatch(List<Attribute> attributes);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(Attribute attribute);

    int count();

    int countByTemplateId(Long templateId);

    AttributeStandardVO getStandardById(Long id);

    List<AttributeListItemVO> list();
}
