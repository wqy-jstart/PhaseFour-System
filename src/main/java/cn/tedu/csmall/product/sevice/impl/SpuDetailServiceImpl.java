package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.SpuDetailMapper;
import cn.tedu.csmall.product.pojo.dto.SpuDetailAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.SpuDetail;
import cn.tedu.csmall.product.sevice.ISpuDetailService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpuDetailServiceImpl implements ISpuDetailService {

    @Autowired
    SpuDetailMapper spuDetailMapper;

    public SpuDetailServiceImpl(){
      log.debug("创建业务接口实现类:SpuDetailServiceImpl");
    }

    @Override
    public void addNew(SpuDetailAddNewDTO spuDetailAddNewDTO) {
        log.debug("开始处理[SPU详情]的业务,参数{}",spuDetailAddNewDTO);
        Long spuId = spuDetailAddNewDTO.getSpuId();
        int count = spuDetailMapper.countBySpuId(spuId);
        if (count>0){
            String message = "添加SPU详情失败,该Spuid已经被占用!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        log.debug("id没有被占用,即将进行添加操作!");
        SpuDetail spuDetail = new SpuDetail();
        BeanUtils.copyProperties(spuDetailAddNewDTO,spuDetail);
        log.debug("开始处理添加数据,{}",spuDetail);
        spuDetailMapper.insert(spuDetail);
        log.debug("添加SPU详情成功!");
    }
}
