package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.mapper.PictureMapper;
import cn.tedu.csmall.product.pojo.dto.PictureAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.PictureStandardVO;
import cn.tedu.csmall.product.service.IPictureService;
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

    @Autowired
    AlbumMapper albumMapper;

    public PictureServiceImpl(){
        log.debug("创建业务对象:PictureServiceImpl");
    }

    /**
     * 添加图片数据
     * @param pictureAddNewDTO 添加的图片信息DTO类
     */
    @Override
    public void addNew(PictureAddNewDTO pictureAddNewDTO) {
        log.debug("开始处理添加[图片]的业务,参数,{}",pictureAddNewDTO);
        AlbumStandardVO albumStandardVO = albumMapper.getStandardById(pictureAddNewDTO.getAlbumId());
        if (albumStandardVO==null){
            String message = "添加失败,该图片对应的相册不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
        Picture picture = new Picture();
        BeanUtils.copyProperties(pictureAddNewDTO,picture);
        log.debug("即将向图片表中添加数据,参数:{}",picture);
        int rows = pictureMapper.insert(picture);
        if (rows>1){
            String message = "添加失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
    }

    /**
     * 根据id删除图片
     * @param id 要删除的图片id
     */
    @Override
    public void delete(Long id) {
        log.debug("开始处理[根据id删除图片]的业务!");
        PictureStandardVO pictureStandardVO = pictureMapper.getStandardById(id);
        if (pictureStandardVO==null){
            String message = "删除失败,该图片id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }
        int rows = pictureMapper.delete(id);
        if (rows>1){
            String message = "删除失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }
    }
}
