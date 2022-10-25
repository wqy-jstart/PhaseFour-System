package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 批量插入类别数据
     * @param categories
     * @return
     */
    int insertBatch(List<Category> categories);

    /**
     * 删除类别数据
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 批量删除类别数量
     * @param ids
     * @return
     */
    int deleteByIds(Long[] ids);

    /**
     * 修改类别数据
     * @param category
     * @return
     */
    int update(Category category);

    /**
     * 查询类别数量
     * @return
     */
    int count();

    /**
     * 查询一条类别数据
     * @param id
     * @return
     */
    CategoryStandardVO getStandardById(Long id);

    /**
     * 查询所有类别数据
     * @return
     */
    List<CategoryListItemVO> list();

}
