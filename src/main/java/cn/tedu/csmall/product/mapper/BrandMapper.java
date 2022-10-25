package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理品牌数据的Mapper接口
 *
 * @Author wqy
 * @Vession 0.0.1
 */
@Repository
public interface BrandMapper {

    /**
     * 处理插入品牌的方法
     * @param brand 品牌实体类
     * @return 影响数据的条数
     */
    int insert(Brand brand);

    /**
     * 批量插入品牌数据
     * @param brands
     * @return
     */
    int insertBatch(List<Brand> brands);

    /**
     * 删除品牌数据
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 批量删除品牌数据
     * @param ids
     * @return
     */
    int deleteByIds(Long[] ids);

    /**
     * 修改品牌数据
     * @return 返回修改的品牌对象
     */
    int update(Brand brand);

    /**
     * 查询品牌数据的数量
     * @return 返回品牌数据的数量
     */
    int count();



}
