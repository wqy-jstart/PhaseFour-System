package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.BrandCategoryAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建品牌分类的Service接口
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Transactional
public interface IBrandCategoryService {

    /**
     * 添加品牌分类
     * @param brandCategoryAddNewDTO 需要添加的品牌分类关联表的数据
     */
    void addNew(BrandCategoryAddNewDTO brandCategoryAddNewDTO);

    /**
     * 根据品牌和类别id来删除关联表中的数据
     * @param brandId 品牌id
     * @param categoryId 类别id
     */
    void delete(Long brandId,Long categoryId);
}
