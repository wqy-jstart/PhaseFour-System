package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;

/**
 * 处理品牌的业务接口
 *
 * @Author Wqy
 * @Version 0.0.1
 */
public interface IBrandService {

    /**
     * 该方法用来执行插入品牌数据
     * @param brandAddNewDTO 要插入的品牌DTO对象
     */
    void addNew(BrandAddNewDTO brandAddNewDTO);

    /**
     * 根据id删除品牌
     *
     * @param id 需要删除的品牌id
     */
    void delete(Long id);
}
