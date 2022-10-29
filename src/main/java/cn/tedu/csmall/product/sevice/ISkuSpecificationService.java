package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.SkuSpecificationAddNewDTO;

/**
 * 创建SKU数据的Service接口
 *
 * @java.@Wqy
 * @Version 0.0.1
 */
public interface ISkuSpecificationService {

    /**
     * 添加SKU数据信息
     * @param skuSpecificationAddNewDTO
     */
    void addNew(SkuSpecificationAddNewDTO skuSpecificationAddNewDTO);
}
