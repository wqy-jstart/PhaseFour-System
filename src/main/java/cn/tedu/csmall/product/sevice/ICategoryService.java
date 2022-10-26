package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;

/**
 * 创建分类的Service接口
 *
 * @Author Wqy
 * @Version 0.0.1
 */
public interface ICategoryService {

    /**
     * 添加分类信息
     * @param categoryAddNewDTO 封装了用户添加的DTO类
     */
    void addNew(CategoryAddNewDTO categoryAddNewDTO);
}
