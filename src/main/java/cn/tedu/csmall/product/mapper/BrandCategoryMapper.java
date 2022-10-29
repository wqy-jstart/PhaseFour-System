package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.BrandCategory;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCategoryMapper {
    int insert(BrandCategory brandCategory);

    int insertBatch(List<BrandCategory> brandCategories);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(BrandCategory brandCategory);

    int count();

    int countByBrandId(Long BrandId);

    BrandCategoryStandardVO getStandardById(Long id);

    List<BrandCategoryListItemVO> list();
}
