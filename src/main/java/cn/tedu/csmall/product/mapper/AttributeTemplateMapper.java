package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.dto.AttributeUpdateInfoDTO;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeTemplateMapper {

    int insert(AttributeTemplate attributeTemplate);

    int insertBatch(List<AttributeTemplate> attributeTemplates);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(AttributeTemplate attributeTemplate);

    /**
     * 统计当前表中非此属性模板id的匹配名称的属性模板数据的数量
     *
     * @param id 当前属性模板id
     * @param name 属性模板名称
     * @return 当前表中非此属性模板id的匹配名称的属性模板数据的数量
     */
    int countByNameAndNotId(@Param("id") Long id ,@Param("name") String name);

    int count();

    int countByName(String name);

    AttributeTemplateStandardVO getStandardById(Long id);

    List<AttributeTemplateListItemVO> list();
}
