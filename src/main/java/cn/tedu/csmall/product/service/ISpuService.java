package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建SPU的Service接口类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Transactional
public interface ISpuService {

    /**
     * 添加SPU
     * @param spuAddNewDTO
     */
    void addNew(SpuAddNewDTO spuAddNewDTO);
}
