package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.CategoryUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 根据id删除类别
     * @param id 类别id
     */
    void deleteById(Long id);

    /**
     * 根据类别id，修改类别详情
     *
     * @param id                类别id
     * @param categoryUpdateDTO 新的类别数据
     */
    void updateInfoById(Long id, CategoryUpdateDTO categoryUpdateDTO);

    /**
     * 处理查询类别列表的功能
     * @return List
     */
    List<CategoryListItemVO> list();

    /**
     * 根据id查询一条菜单详情
     * @param id 菜单id
     * @return 返回菜单详情VO类
     */
    CategoryStandardVO selectById(Long id);

    /**
     * 根据父级类别查询其自己类别列表
     * @param parentId 父级类别id
     * @return 返回查询的子级列表
     */
    List<CategoryListItemVO> listByParentId(Long parentId);

    /**
     * 处理启用分类的功能
     * @param id 要启用的分类id
     */
    void setEnable(Long id);

    /**
     * 处理禁用分类的功能
     * @param id 要禁用的分类id
     */
    void setDisable(Long id);

    /**
     * 处理显示分类在导航栏中的功能
     * @param id 显示分类的id
     */
    void setDisplay(Long id);

    /**
     * 处理不显示分类在导航栏中的功能
     * @param id 隐藏的分类id
     */
    void setHidden(Long id);
}
