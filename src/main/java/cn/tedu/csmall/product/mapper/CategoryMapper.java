package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;

/**
 * 处理类别数据的Mapper接口
 *
 * @Author wqy
 * @Vession 0.0.1
 */
public interface CategoryMapper {

    /**
     * 处理插入类别的方法
     * @param category 类别的实体类
     * @return 返回影响的条数
     */
    int insert(Category category);

}
