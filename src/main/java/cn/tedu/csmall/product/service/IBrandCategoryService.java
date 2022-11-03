package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.BrandCategoryAddNewDTO;

/**
 * 创建品牌分类的Service接口
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
public interface IBrandCategoryService {

    /**
     * 添加品牌分类
     * @param brandCategoryAddNewDTO
     */
    void addNew(BrandCategoryAddNewDTO brandCategoryAddNewDTO);
}
