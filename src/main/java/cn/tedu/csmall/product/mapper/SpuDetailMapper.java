package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.SpuDetail;
import cn.tedu.csmall.product.pojo.vo.SpuDetailListItemVO;
import cn.tedu.csmall.product.pojo.vo.SpuDetailStandardVO;
import cn.tedu.csmall.product.pojo.vo.SpuListItemVO;
import cn.tedu.csmall.product.pojo.vo.SpuStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuDetailMapper {
    int insert(SpuDetail spuDetail);

    int insertBatch(List<SpuDetail> spuDetails);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(SpuDetail spuDetail);

    int count();

    int countBySpuId(Long spuId);

    SpuDetailStandardVO getStandardById(Long id);

    List<SpuDetailListItemVO> list();
}
