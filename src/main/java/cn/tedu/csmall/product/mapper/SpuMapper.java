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

    /**
     * 查询albumId下的所有SPU数据
     * @param albumId albumId
     * @return 返回数据的数量
     */
    int countByAlbumId(Long albumId);

    /**
     * 查询brandId下的所有SPU数据
     * @param brandId brandId
     * @return 返回数据的数量
     */
    int countByBrandId(Long brandId);

    /**
     * 根据分类id查询SPU数据
     * @param categoryId
     * @return
     */
    int countByCategoryId(Long categoryId);

    /**
     * 查询attributeTemplateId下的所有SPU数据
     * @param attributeTemplateId
     * @return
     */
    int countByAttributeTemplateId(Long attributeTemplateId);

    SpuStandardVO getStandardById(Long id);

    List<SpuListItemVO> list();
}
