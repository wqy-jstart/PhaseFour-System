package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据名称和TemplateId来查询数据的条数
     * @param name 属性名称
     * @param templateId 模板id
     * @return 返回查询的数量
     */
    int countByNameAndTemplateId(@Param("name") String name,@Param("templateId") Long templateId);

    AttributeStandardVO getStandardById(Long id);

    List<AttributeListItemVO> list();
}
