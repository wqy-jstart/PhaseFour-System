package cn.tedu.csmall.product.mapper;


import cn.tedu.csmall.product.pojo.entity.SkuSpecification;
import cn.tedu.csmall.product.pojo.vo.SkuSpecificationListItemVO;
import cn.tedu.csmall.product.pojo.vo.SkuSpecificationStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuSpecificationMapper {
    int insert(SkuSpecification skuSpecification);

    int insertBatch(List<SkuSpecification> skuSpecifications);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(SkuSpecification skuSpecification);

    int count();

    int countBySkuId(Long skuId);

    SkuSpecificationStandardVO getStandardById(Long id);

    List<SkuSpecificationListItemVO> list();
}
