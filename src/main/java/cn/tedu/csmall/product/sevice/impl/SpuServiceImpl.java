package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.SpuMapper;
import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Spu;
import cn.tedu.csmall.product.sevice.ISpuService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建SPU的Service接口实现类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class SpuServiceImpl implements ISpuService {

    @Autowired
    SpuMapper spuMapper;

    public SpuServiceImpl(){
        log.debug("创建接口实现类:SpuServiceImpl");
    }

    @Override
    public void addNew(SpuAddNewDTO spuAddNewDTO) {
        log.debug("开始处理[SPU]的业务,参数,{}",spuAddNewDTO);
        Long albumId = spuAddNewDTO.getAlbumId();
        int count = spuMapper.countByAlbumId(albumId);
        if (count>0){
            String message = "添加SPU数据失败,该名称已经被占用!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        log.debug("该名称没有被占用,即将进行添加操作");
        Spu spu = new Spu();
        BeanUtils.copyProperties(spuAddNewDTO,spu);
        log.debug("开始插入数据!");
        spuMapper.insert(spu);
        log.debug("插入数据成功!");
    }
}
