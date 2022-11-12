package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandCategoryMapper;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.mapper.CategoryMapper;
import cn.tedu.csmall.product.pojo.dto.BrandCategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.BrandCategory;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.IBrandCategoryService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 品牌分类接口的Service实现类
 */
@Slf4j
@Service
public class BrandCategoryServiceImpl implements IBrandCategoryService {

    @Autowired
    BrandCategoryMapper brandCategoryMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    CategoryMapper categoryMapper;


    public BrandCategoryServiceImpl(){
        log.debug("创建业务实现类:BrandCategoryServiceImpl");
    }
    @Override
    public void addNew(BrandCategoryAddNewDTO brandCategoryAddNewDTO) {
        log.debug("开始处理[添加品牌分类]的业务,参数,{}",brandCategoryAddNewDTO);

        // 判断品牌是否存在
        BrandStandardVO brandStandardVO = brandMapper.getStandardById(brandCategoryAddNewDTO.getBrandId());
        if (brandStandardVO==null){
            String message = "添加失败,该品牌不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }

        // 判断类别是否存在
        CategoryStandardVO categoryStandardVO = categoryMapper.getStandardById(brandCategoryAddNewDTO.getCategoryId());
        if (categoryStandardVO==null){
            String message = "添加失败,该类别不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }

        // 判断绑定的关系原本是否存在
        int count = brandCategoryMapper.countByBrandAndCategoryId(brandCategoryAddNewDTO.getBrandId(),brandCategoryAddNewDTO.getCategoryId());
        if (count>0){
            String message = "添加品牌分类失败,尝试绑定的关系原本已存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        log.debug("即将向表中插入数据,参数:{}",brandCategoryAddNewDTO);
        BrandCategory brandCategory = new BrandCategory();
        BeanUtils.copyProperties(brandCategoryAddNewDTO,brandCategory);
        LocalDateTime now =  LocalDateTime.now();
        brandCategory.setGmtCreate(now);
        brandCategory.setGmtModified(now);
        log.debug("即将插入品牌分类数据:{}",brandCategory);
        int rows = brandCategoryMapper.insert(brandCategory);
        if (rows>1){
            String message = "添加失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
        log.debug("插入品牌分类数据完成!");
    }

    /**
     * 根据品牌id和类别id来解绑业务
     * @param brandId 品牌id
     * @param categoryId 类别id
     */
    @Override
    public void delete(Long brandId, Long categoryId) {
        log.debug("开始根据品牌和类别id进行解绑业务!,品牌id:{},类别id:{}",brandId,categoryId);
        // 判断绑定的关系是否存在
        int count = brandCategoryMapper.countByBrandAndCategoryId(brandId,categoryId);
        if (count==0){
            String message = "删除失败,绑定关系不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }

        log.debug("即将执行删除绑定数据的业务");
        int rows = brandCategoryMapper.delete(brandId,categoryId);
        if (rows>1){
            String message = "删除失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }
    }
}
