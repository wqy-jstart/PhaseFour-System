package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.SpuDetailAddNewDTO;

/**
 * 创建了SPU详情的Service接口
 */
public interface ISpuDetailService {

    /**
     * 添加SPU详情
     * @param spuDetailAddNewDTO
     */
    void addNew(SpuDetailAddNewDTO spuDetailAddNewDTO);
}
