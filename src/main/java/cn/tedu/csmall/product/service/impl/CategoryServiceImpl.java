package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.*;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.CategoryUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理分类接口的接口实现类
 */
@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    // 自动装配组件中的Bean对象
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandCategoryMapper brandCategoryMapper;

    @Autowired
    private CategoryAttributeTemplateMapper categoryAttributeTemplateMapper;

    @Autowired
    private SpuMapper spuMapper;

    public CategoryServiceImpl() {
        log.debug("创建业务对象:BrandServiceImpl");
    }

    /**
     * 处理添加分类的业务
     *
     * @param categoryAddNewDTO 封装了用户添加的DTO类
     */
    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理[添加分类]的业务,参数{}", categoryAddNewDTO);

        // 查询父级类别
        Integer depth = 1;// 默认深度为1
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
        log.debug("当前尝试添加的类型的depth值为:{}", depth);

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
        int rows = categoryMapper.insert(category);
        if (rows != 1) {// 如果插入所影响的行数不为1
            String message = "添加类别失败,服务器忙,请稍后再尝试!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }

//        category.getGmtCreate().toString();

        // 检查当前新增类型的父级类别，如果父类别的isParent为0，则将父级类别的isParent更新为1
        if (parentId != 0) { // 如果当前的父级id不为0,说明存在父类
            if (parentCategory.getIsParent() == 0) { // 如果父级的isParent为0(暂时没有子级的情况)
                // 创建一个分类对象,用来修改父级的isParent(需设置id过滤条件)
                Category updateParentCategory = new Category();
                updateParentCategory.setId(parentId);// ★设置id为子级的ParentId,用来作为过滤条件修改父级的IsParent
                updateParentCategory.setIsParent(1);// 修改父级的IsParent为1
                log.debug("将父级类别的isParent更新为1,更新的参数对象:{}", updateParentCategory);
                categoryMapper.update(updateParentCategory);
            }
        }
    }

    /**
     * 根据id删除分类数据
     *
     * @param id 类别id
     */
    @Override
    public void deleteById(Long id) {
        log.debug("开始处理[根据id删除类别]的业务,参数,{}", id);
        CategoryStandardVO categoryStandardVO = categoryMapper.getStandardById(id);

        if (categoryStandardVO == null) {
            String message = "删除失败,该id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }

        // 检查当前尝试删除的类别是否存在子级类别：判断以上查询结果的isParent是否为1
        if (categoryStandardVO.getIsParent() == 1) {
            // 是：当前尝试删除的类别“是父级类别”（包含子级），抛出异常（ERR_CONFLICT）
            String message = "删除类别失败，尝试删除的类别仍包含子级类别！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        // 如果此类别关联了品牌，则不允许删除
        {
            int count = brandCategoryMapper.countByCategoryId(id);
            if (count > 0) {
                String message = "删除类别失败,该类别包含关联品牌的数据!";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        // 如果此类别关联了属性模板，则不允许删除
        {
            int count = categoryAttributeTemplateMapper.countByCategoryId(id);
            if (count > 0) {
                String message = "删除类别失败,该类别包含关联属性模板的数据!";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_DELETE, message);
            }
        }

        // 如果此类别关联了SPU，则不允许删除
        {
            int count = spuMapper.countByCategoryId(id);
            if (count > 0) {
                String message = "删除类别失败,该类别包含关联SPU的数据!";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_DELETE, message);
            }
        }

        // 注意：删除时，如果删到某个类别没有子级了，需要将它的isParent更新为0
        Long parentId = categoryStandardVO.getParentId();// 获取该id下的类别父级id
        if (parentId != 0) { // 说明该类别归属于某个父级
            int count = categoryMapper.countByParentId(parentId);
            // 判断统计结果是否为1,为1说明是最后一个子集
            if (count == 1) {
                // 创建新的Category对象，用于更新父级，此Category对象中需要封装：id（parentId），isParent（0）
                Category category = new Category();
                category.setId(parentId);
                category.setIsParent(0);
                log.debug("将id为{}类别的isParent改为0", parentId);
                int rows = categoryMapper.update(category);
                // 判断返回值是否不为1
                if (rows != 1) {
                    // 是：抛出异常（ERR_UPDATE）
                    String message = "删除类别失败，服务器忙，请稍后再尝试！";
                    log.warn(message);
                    throw new ServiceException(ServiceCode.ERR_UPDATE, message);
                }
            }
        }

        log.debug("即将执行删除id为{}的类别数据", id);
        int rows = categoryMapper.deleteById(id);
        if (rows > 1) {
            String message = "删除失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
    }

    /**
     * 根据id修改类别数据
     *
     * @param id                类别id
     * @param categoryUpdateDTO 新的类别数据
     */
    @Override
    public void updateInfoById(Long id, CategoryUpdateDTO categoryUpdateDTO) {
        log.debug("开始处理[根据id修改类别信息]的业务");
        CategoryStandardVO categoryStandardVO = categoryMapper.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = "修改失败,该类别id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        int count = categoryMapper.countByNameAndNotId(id, categoryUpdateDTO.getName());
        if (count > 0) {
            String message = "修改失败,修改的类别名称已存在";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateDTO, category);
        category.setId(id);

        int rows = categoryMapper.update(category);
        if (rows != 1) {
            String message = "服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }

    /**
     * 处理查询类别列表的业务
     *
     * @return List
     */
    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始处理查询类别列表的业务!");
        return categoryMapper.list();
    }

    /**
     * 根据类别id查询类别详情
     *
     * @param id 菜单id
     * @return 返回类别详情的Vo类
     */
    @Override
    public CategoryStandardVO selectById(Long id) {
        log.debug("开始根据id:{}来查询菜单详情", id);
        CategoryStandardVO categoryStandardVO = categoryMapper.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = "查询失败,该id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_SELECT, message);
        }
        return categoryStandardVO;
    }

    /**
     * 处理根据父级类别查询自己类别的业务
     * @param parentId 父级类别id
     * @return
     */
    @Override
    public List<CategoryListItemVO> listByParentId(Long parentId) {
        log.debug("开始处理[根据父级类别查询自己类别]的业务!");
        return categoryMapper.listByParentId(parentId);
    }

    /**
     * 处理启用分类
     *
     * @param id 要启用的分类id
     */
    @Override
    public void setEnable(Long id) {
        updateEnableById(id, 1);
    }

    /**
     * 处理禁用分类
     *
     * @param id 要禁用的分类id
     */
    @Override
    public void setDisable(Long id) {
        updateEnableById(id, 0);
    }

    /**
     * 处理显示分类
     *
     * @param id 显示分类的id
     */
    @Override
    public void setDisplay(Long id) {
        updateDisplayById(id, 1);
    }

    /**
     * 处理隐藏分类
     *
     * @param id 隐藏的分类id
     */
    @Override
    public void setHidden(Long id) {
        updateDisplayById(id, 0);
    }

    /**
     * 处理启用与禁用的逻辑
     */
    private void updateEnableById(Long id, Integer enable) {
        String[] tips = {"禁用", "启用"};
        log.debug("开始处理[{}分类]的业务,id参数为{}", tips[enable], id);
        // 根据id查询分类详情
        CategoryStandardVO categoryStandardVO = categoryMapper.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = tips[enable] + "分类失败,尝试访问的数据不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        // 判断查询结果中的enable与方法参数enable是否相同
        if (enable.equals(categoryStandardVO.getEnable())) {
            String message = tips[enable] + "分类失败，管理员账号已经处于" + tips[enable] + "状态！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        // 创建category对象,并封装id和enable这2个属性的值,并进行修改
        Category category = new Category();
        category.setId(id);
        category.setEnable(enable);
        int rows = categoryMapper.update(category);
        if (rows != 1) {
            String message = tips[enable] + "分类失败，服务器忙，请稍后再次尝试！";
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
        log.debug("修改成功!");
    }

    /**
     * 处理显示和隐藏的逻辑
     */
    private void updateDisplayById(Long id, Integer display) {
        String[] tips = {"隐藏", "显示"};
        log.debug("开始处理[{}分类]的业务,id参数为{}", tips[display], id);
        // 查询分类详情
        CategoryStandardVO categoryStandardVO = categoryMapper.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = tips[display] + "分类失败,尝试访问的数据不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        // 判断查询结果中的display与方法参数display是否相同
        if (display.equals(categoryStandardVO.getIsDisplay())) {
            String message = tips[display] + "分类失败，管理员账号已经处于" + tips[display] + "状态！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        // 创建category对象,并封装id和display这2个属性的值,并进行修改
        Category category = new Category();
        category.setId(id);
        category.setIsDisplay(display);
        int rows = categoryMapper.update(category);
        if (rows != 1) {
            String message = tips[display] + "分类失败，服务器忙，请稍后再次尝试！";
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
        log.debug("修改成功!");
    }
}
