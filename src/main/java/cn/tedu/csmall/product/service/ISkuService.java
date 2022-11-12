package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.SkuAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建SKU的Service接口
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Transactional
public interface ISkuService {

    /**
     * 添加SKU
     * @param skuAddNewDTO
     */
    void addNew(SkuAddNewDTO skuAddNewDTO);
}
