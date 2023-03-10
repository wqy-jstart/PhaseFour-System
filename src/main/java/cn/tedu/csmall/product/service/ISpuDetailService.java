package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.SpuDetailAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建了SPU详情的Service接口
 */
@Transactional
public interface ISpuDetailService {

    /**
     * 添加SPU详情
     * @param spuDetailAddNewDTO
     */
    void addNew(SpuDetailAddNewDTO spuDetailAddNewDTO);
}
