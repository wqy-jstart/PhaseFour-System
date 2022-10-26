package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.sevice.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理品牌业务接口的实现类
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    //检测该品牌业务实现类是否创建成功?
    public BrandServiceImpl(){
        log.debug("创建业务对象:BrandServiceImpl");
    }

    /**
     * 实现Service接口中添加品牌的方法
     *
     * @param brandAddNewDTO 要插入的品牌DTO对象
     */
    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理[添加品牌]的业务,参数{}",brandAddNewDTO);
        //从参数对象中获取DTO对象的名称
        String brandName = brandAddNewDTO.getName();
        //检查相册名称是否已经被占用(相册表中是否已经存在此名称的数据)
        log.debug("检查品牌名称是否已经被占用");
        int count = brandMapper.countByName(brandName);
        if (count>0){
            String message = "添加品牌失败,品牌名称已经被占用";
            log.debug(message);
            throw new ServiceException(message);
        }

        log.debug("品牌名称没有被占用,将向品牌表中插入数据");
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO,brand);
        log.debug("即将插入相册数据:{}",brand);
        brandMapper.insert(brand);
        log.debug("插入品牌数据完成!");
    }
}
