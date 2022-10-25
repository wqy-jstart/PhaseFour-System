package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import org.springframework.stereotype.Repository;

/**
 * 处理类别数据的Mapper接口
 *
 * @Author wqy
 * @Vession 0.0.1
 */
@Repository//该注解用于引导IDEA作出正确的判断
public interface CategoryMapper {

    /**
     * 处理插入类别的方法
     * @param category 类别的实体类
     * @return 返回影响的条数
     */
    int insert(Category category);

}
