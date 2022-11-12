package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.BrandCategory;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryStandardVO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCategoryMapper {
    int insert(BrandCategory brandCategory);

    /**
     * 根据品牌和类别id进行解绑
     * @param brandId 品牌id
     * @param categoryId 类别id
     * @return 返回删除后影响的行数
     */
    int delete(@Param("brandId") Long brandId,@Param("categoryId") Long categoryId);

    int count();

    int countByBrandId(Long BrandId);

    int countByCategoryId(Long categoryId);

    /**
     * 根据品牌id和类别id查询数据
     * @param brandId 品牌id
     * @param categoryId 类别id
     * @return 返回查询的数量
     */
    int countByBrandAndCategoryId(@Param("brandId") Long brandId, @Param("categoryId") Long categoryId);

    BrandCategoryStandardVO getStandardById(Long id);

    List<BrandCategoryListItemVO> list();
}
