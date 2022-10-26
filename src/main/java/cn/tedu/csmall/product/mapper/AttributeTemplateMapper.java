package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeTemplateMapper {

    int insert(AttributeTemplate attributeTemplate);

    int insertBatch(List<AttributeTemplate> attributeTemplates);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(AttributeTemplate attributeTemplate);

    int count();

    int countByName(String name);

    AttributeTemplateStandardVO getStandardById(Long id);

    List<AttributeTemplateListItemVO> list();
}
