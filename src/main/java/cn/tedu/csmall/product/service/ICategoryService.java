package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建分类的Service接口
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Transactional//添加该事务注解可在报错的情况下,IDEA仅会在内存中执行操作,但不会向数据库中插入内容(保存到硬盘中),保证安全性
public interface ICategoryService {

    /**
     * 添加分类信息
     * @param categoryAddNewDTO 封装了用户添加的DTO类
     */
    void addNew(CategoryAddNewDTO categoryAddNewDTO);
}
