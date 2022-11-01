package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.PictureMapper;
import cn.tedu.csmall.product.pojo.dto.PictureAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.sevice.IPictureService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图片业务的实现类
 *
 * @Author java.@Wqy
 * @Verson 0.0.1
 */
@Slf4j
@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    PictureMapper pictureMapper;

    public PictureServiceImpl(){
        log.debug("创建业务对象:PictureServiceImpl");
    }

    @Override
    public void addNew(PictureAddNewDTO pictureAddNewDTO) {
        log.debug("开始处理添加[图片]的业务,参数,{}",pictureAddNewDTO);
        String pictureUrl = pictureAddNewDTO.getUrl();
        log.debug("检查图片名称是否已经被占用");
        int count = pictureMapper.countByUrl(pictureUrl);
        if (count>0){
            String message = "添加图片失败,Url已经被占用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        log.debug("图片名称没有被占用,将向相册表中插入数据");
        Picture picture = new Picture();
        BeanUtils.copyProperties(pictureAddNewDTO,picture);
        log.debug("即将插入图片数据:{}", picture);
        pictureMapper.insert(picture);
        log.debug("插入图片数据完成!");
    }
}
