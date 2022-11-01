package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.CategoryAttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.CategoryAttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryAttributeTemplateStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理菜单属性数据的Mapper接口,创建DAO层
 */
@Repository
public interface CategoryAttributeTemplateMapper {

    /**
     * 插入类别与属性模板关联数据
     * @param categoryAttributeTemplate
     * @return
     */
    int insert(CategoryAttributeTemplate categoryAttributeTemplate);

    int insertBatch(List<CategoryAttributeTemplate> categoryAttributeTemplates);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(CategoryAttributeTemplate categoryAttributeTemplate);

    int count();

    int countByAttributeTemplateId(Long attributeTemplateId);

    CategoryAttributeTemplateStandardVO getStandardById(Long id);

    List<CategoryAttributeTemplateListItemVO> list();

}
