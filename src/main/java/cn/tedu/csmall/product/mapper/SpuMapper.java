package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Spu;
import cn.tedu.csmall.product.pojo.vo.SkuSpecificationListItemVO;
import cn.tedu.csmall.product.pojo.vo.SkuSpecificationStandardVO;
import cn.tedu.csmall.product.pojo.vo.SpuListItemVO;
import cn.tedu.csmall.product.pojo.vo.SpuStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuMapper {
    int insert(Spu spu);

    int insertBatch(List<Spu> spus);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(Spu spu);

    int count();

    int countByName(String name);

    SpuStandardVO getStandardById(Long id);

    List<SpuListItemVO> list();
}
