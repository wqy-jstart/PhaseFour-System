package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.SkuMapper;
import cn.tedu.csmall.product.pojo.dto.SkuAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Sku;
import cn.tedu.csmall.product.sevice.ISkuService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SkuServiceImpl implements ISkuService {

    @Autowired
    SkuMapper skuMapper;

    public SkuServiceImpl(){
        log.debug("创建业务实现类:SkuServiceImpl");
    }


    @Override
    public void addNew(SkuAddNewDTO skuAddNewDTO) {
        log.debug("开始处理[SKU]的业务,参数{}",skuAddNewDTO);
        String skuTitle = skuAddNewDTO.getTitle();
        int count = skuMapper.countByTitle(skuTitle);
        if (count>0){
            String message = "添加SKU失败,标题已经存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        log.debug("标题没有被占用,即将进行添加操作!");
        Sku sku = new Sku();
        BeanUtils.copyProperties(skuAddNewDTO,sku);
        log.debug("即将插入数据,{}",sku);
        skuMapper.insert(sku);
        log.debug("添加数据成功!");
    }
}
