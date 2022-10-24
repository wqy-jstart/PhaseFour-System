package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;

/**
 * 处理品牌数据的Mapper接口
 *
 * @Author wqy
 * @Vession 0.0.1
 */
public interface BrandMapper {

    /**
     * 处理插入品牌的方法
     * @param brand 品牌实体类
     * @return 影响数据的条数
     */
    int insert(Brand brand);

}
