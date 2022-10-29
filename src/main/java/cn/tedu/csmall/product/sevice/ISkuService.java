package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.SkuAddNewDTO;

/**
 * 创建SKU的Service接口
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
public interface ISkuService {

    /**
     * 添加SKU
     * @param skuAddNewDTO
     */
    void addNew(SkuAddNewDTO skuAddNewDTO);
}
