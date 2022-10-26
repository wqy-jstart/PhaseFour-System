package cn.tedu.csmall.product.sevice.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.sevice.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//实现相册Service层接口中的方法,在方法中处理相关的业务逻辑

/**
 * 处理相册的业务实现类
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired//将相册的Mapper接口注入进来
    private AlbumMapper albumMapper;

    //检测该相册业务实现类是否创建成功?
    public AlbumServiceImpl() {
        log.debug("创建业务对象:AlbumServiceImpl");
    }

    /**
     * 实现Service接口中添加相册的方法,在方法内处理该业务逻辑
     *
     * @param albumAddNewDTO 相册数据DTO
     */
    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理[添加相册]的业务,参数:{}", albumAddNewDTO);
        // 从参数对象中获取相册名称
        String albumName = albumAddNewDTO.getName();
        // 检查相册名称是否已经被占用（相册表中是否已经存在此名称的数据）
        log.debug("检查相册名称是否已经被占用");
        int count = albumMapper.countByName(albumName);
        if (count > 0) {
            // 是：相册名称已经被占用，添加相册失败，抛出异常
            String message = "添加相册失败,相册名称已经被占用!";
            log.debug(message);
            throw new ServiceException(message);//抛出异常
        }
        // 否：相册名称没有被占用，则向相册表中插入数据
        log.debug("相册名称没有被占用,将向相册表中插入数据");
        Album album = new Album();
//        album.getName().toLowerCase();测试空指针->运行时异常,因为刚New的对象,Name为Null
        BeanUtils.copyProperties(albumAddNewDTO, album);//将前者实体类中的信息复制到后者实体类中
        log.debug("即将插入相册数据:{}", album);
        albumMapper.insert(album);
        log.debug("插入相册数据完成!");
    }
}
