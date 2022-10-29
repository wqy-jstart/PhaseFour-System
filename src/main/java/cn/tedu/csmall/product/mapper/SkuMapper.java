package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Sku;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryStandardVO;
import cn.tedu.csmall.product.pojo.vo.SkuListItemVO;
import cn.tedu.csmall.product.pojo.vo.SkuStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuMapper {
    int insert(Sku sku);

    int insertBatch(List<Sku> skus);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(Sku sku);

    int count();

    int countByTitle(String title);

    SkuStandardVO getStandardById(Long id);

    List<SkuListItemVO> list();
}
