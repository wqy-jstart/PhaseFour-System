package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.CategoryMapper;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.sevice.ICategoryService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 处理分类接口的接口实现类
 */
@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl() {
        log.debug("创建业务对象:BrandServiceImpl");
    }

    /**
     * 处理添加分类的业务
     *
     * @param categoryAddNewDTO 封装了用户添加的DTO类
     */
    @Override
    @Transactional//添加该事务注解可在报错的情况下,IDEA仅会在内存中执行操作,但不会向数据库中插入内容(保存到硬盘中),保证安全性
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理[添加分类]的业务,参数{}", categoryAddNewDTO);

        // 查询父级类别
        Integer depth = 1;
        Long parentId = categoryAddNewDTO.getParentId();//获取客户端传入的父级id
        CategoryStandardVO parentCategory = null;
        if (parentId != 0) { // 如果父级id不为0,说明归属于某个父级
            // 确定当前类的depth值, 为:父级depth + 1
            parentCategory = categoryMapper.getStandardById(parentId);// 根据父级id去查找父级对象

            if (parentCategory == null) { // 如果为null,说明没有这个父级,抛出异常
                String message = "添加类别失败,所选择的父级类别不存在!";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
            }
            depth = parentCategory.getDepth() + 1;// 否则有这个父级,将自己的depth深度调整为(父级深度+1)
        }
        log.debug("当前尝试添加的类型的depth值为:{}",depth);

        // 调用Mapper对象的【根据名称统计数量】方法进行统计,添加前判断该名称是否存在
        String name = categoryAddNewDTO.getName();
        log.debug("检查分类名称是否已经被占用");
        int count = categoryMapper.countByName(name);
        log.debug("根据名称【{}】统计数量：{}", name, count);
        if (count > 0) {
            String message = "添加分类失败,分类名称已经被占用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        log.debug("分类名称没有被占用,将向分类表中插入数据");
        // ★补全Category对象的值
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewDTO, category);
        // 补全Category对象的值：depth >>> 使用最终的depth变量
        category.setDepth(depth);
        // 补全Category对象的值: isParent >>> 0，新增的类别的isParent固定为0
        category.setIsParent(0);//固定先为0
        log.debug("即将插入分类数据:{}", category);
        categoryMapper.insert(category);

//        category.getGmtCreate().toString();

        // 检查当前新增类型的父级类别，如果父类别的isParent为0，则将父级类别的isParent更新为1
        if (parentId !=0){ // 如果当前的父级id不为0,说明存在父类
            if (parentCategory.getIsParent() == 0){ // 如果父级的isParent为0(暂时没有子级的情况)
                // 创建一个分类对象,用来修改父级的isParent(需设置id过滤条件)
                Category updateParentCategory = new Category();
                updateParentCategory.setId(parentId);// ★设置id为子级的ParentId,用来作为过滤条件修改父级的IsParent
                updateParentCategory.setIsParent(1);// 修改父级的IsParent为1
                log.debug("将父级类别的isParent更新为1,更新的参数对象:{}",updateParentCategory);
                categoryMapper.update(updateParentCategory);
            }
        }
    }
    // 注意：删除时，如果删到某个类别没有子级了，需要将它的isParent更新为0
}
