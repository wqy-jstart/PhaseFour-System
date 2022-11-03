package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandCategoryMapper;
import cn.tedu.csmall.product.pojo.dto.BrandCategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.BrandCategory;
import cn.tedu.csmall.product.service.IBrandCategoryService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 品牌分类接口的Service实现类
 */
@Slf4j
@Service
public class BrandCategoryServiceImpl implements IBrandCategoryService {

    @Autowired
    BrandCategoryMapper brandCategoryMapper;

    public BrandCategoryServiceImpl(){
        log.debug("创建业务实现类:BrandCategoryServiceImpl");
    }
    @Override
    public void addNew(BrandCategoryAddNewDTO brandCategoryAddNewDTO) {
        log.debug("开始处理[添加品牌分类]的业务,参数,{}",brandCategoryAddNewDTO);

        Long brandCategoryId = brandCategoryAddNewDTO.getBrandId();
        int count = brandCategoryMapper.countByBrandId(brandCategoryId);
        if (count>0){
            String message = "添加品牌分类失败,该Id已经被占用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        log.debug("品牌分类没有被占用,将向表中插入数据");
        BrandCategory brandCategory = new BrandCategory();
        BeanUtils.copyProperties(brandCategoryAddNewDTO,brandCategory);
        log.debug("即将插入品牌分类数据:{}",brandCategory);
        brandCategoryMapper.insert(brandCategory);
        log.debug("插入品牌分类数据完成!");
    }
}
