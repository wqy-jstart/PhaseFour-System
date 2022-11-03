package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.SkuSpecificationMapper;
import cn.tedu.csmall.product.pojo.dto.SkuSpecificationAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.SkuSpecification;
import cn.tedu.csmall.product.service.ISkuSpecificationService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SKU数据的接口实现类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class SkuSpecificationServiceImpl implements ISkuSpecificationService {

    @Autowired
    SkuSpecificationMapper skuSpecificationMapper;

    public SkuSpecificationServiceImpl(){
        log.debug("创建接口实现类:SkuSpecificationServiceImpl");
    }


    @Override
    public void addNew(SkuSpecificationAddNewDTO skuSpecificationAddNewDTO) {
        log.debug("开始处理添加[SKU数据]的业务,参数:{}",skuSpecificationAddNewDTO);

        Long skuId = skuSpecificationAddNewDTO.getSkuId();
        int count = skuSpecificationMapper.countBySkuId(skuId);
        if (count>0){
            String message = "添加SKU数据失败,该Id已经存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        log.debug("开始处理SKU数据的添加!");
        SkuSpecification skuSpecification = new SkuSpecification();
        BeanUtils.copyProperties(skuSpecificationAddNewDTO,skuSpecification);
        log.debug("开始插入数据:{}",skuSpecification);
        skuSpecificationMapper.insert(skuSpecification);
        log.debug("添加数据成功!");
    }
}
