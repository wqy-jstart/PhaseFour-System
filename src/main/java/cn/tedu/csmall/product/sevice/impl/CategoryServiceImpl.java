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

/**
 * 处理分类接口的接口实现类
 */
@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(){
        log.debug("创建业务对象:BrandServiceImpl");
    }

    /**
     * 处理添加分类的业务
     * @param categoryAddNewDTO 封装了用户添加的DTO类
     */
    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理[添加分类]的业务,参数{}",categoryAddNewDTO);

        // 查询父级类别
        Integer depth;
        Long parentId = categoryAddNewDTO.getParentId();
        if (parentId ==0){
            // 确定当前类别的depth的值,为:1
            depth = 1;
        }else {
            // 确定当前类的depth值, 为:父级depth + 1
            CategoryStandardVO parentCategory = categoryMapper.getStandardById(parentId);
            if (parentCategory == null){
                String message = "添加类别失败,所选择的父级类别不存在!";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
            }else {
                depth = parentCategory.getDepth()+1;
            }
        }


        String name = categoryAddNewDTO.getName();
        log.debug("检查分类名称是否已经被占用");
        int count = categoryMapper.countByName(name);
        if (count>0){
            String message = "添加分类失败,分类名称已经被占用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        log.debug("分类名称没有被占用,将向分类表中插入数据");
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewDTO,category);
        // 补全Category对象的值：depth >>> 使用以上的depth变量
        category.setDepth(depth);
        // 补全Category对象的值: isParent >>> 0，新增的类别的isParent固定为0
        category.setIsParent(0);
        log.debug("即将插入分类数据:{}",category);
        categoryMapper.insert(category);

        // TODO 检查当前新增类型的父级类别，如果父类别的isParent为0，则将父级类别的isParent更新为1
    }
    // 注意：删除时，如果删到某个类别没有子级了，需要将它的isParent更新为0
}
