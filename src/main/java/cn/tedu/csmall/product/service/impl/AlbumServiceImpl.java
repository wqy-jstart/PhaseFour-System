package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.mapper.PictureMapper;
import cn.tedu.csmall.product.mapper.SpuMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AlbumUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//实现相册Service层接口中的方法,在方法中处理相关的业务逻辑

/**
 * 处理相册的业务实现类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
@Resource
public class AlbumServiceImpl implements IAlbumService {

    @Autowired// 将相册的Mapper接口注入进来
    private AlbumMapper albumMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private SpuMapper spuMapper;

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
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);//抛出异常时,传递状态码和信息
        }
        // 否：相册名称没有被占用，则向相册表中插入数据
        log.debug("相册名称没有被占用,将向相册表中插入数据");
        Album album = new Album();
//        album.getName().toLowerCase();测试空指针->运行时异常,因为刚New的对象,Name为Null
        BeanUtils.copyProperties(albumAddNewDTO, album);//将前者实体类中的信息复制到后者实体类中
        log.debug("即将插入相册数据:{}", album);
        int rows = albumMapper.insert(album);
        if (rows != 1){// 如果插入所影响的行数不为1
            String message = "添加相册失败,服务器忙,请稍后再尝试!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
        log.debug("插入相册数据完成!");
    }

    /**
     * 实现根据相册id删除相册数据的功能
     *
     * @param id 需要删除的相册id
     */
    @Override
    public void delete(Long id) {
        log.debug("开始处理[根据id删除相册]的业务,参数,{}", id);
        // 调用Mapper对象的getStandardById()执行查询
        AlbumStandardVO queryResult = albumMapper.getStandardById(id);
        // 判断查询结果是否为Null
        if (queryResult == null) {
            // 是: 无此id对应的数据，将不允许执行删除操作，则抛出异常
            String message = "删除相册失败，尝试访问的数据不存在！";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 检查是否存在图片（picture）关联到此相册，如果存在，则不允许删除
        {
            int count = pictureMapper.countByAlbumId(id);
            if (count > 0) {
                String message = "删除相册失败,此相册存在关联的图片数据";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        // 检查是否存在SPU关联到此相册,如果存在,则不允许删除
        {
            int count = spuMapper.countByAlbumId(id);
            if (count > 0) {
                String message = "删除相册失败,此相册存在关联的SPU数据";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        // 调用Mapper对象的deleteById()方法执行删除
        log.debug("即将执行删除,参数:{}", id);
        int rows = albumMapper.deleteById(id);
        if (rows != 1){// 如果插入所影响的行数不为1
            String message = "删除相册失败,服务器忙,请稍后再尝试!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }
    }

    /**
     * 根据id修改相册数据
     * @param id             相册id
     * @param albumUpdateDTO 新的相册数据
     */
    @Override
    public void updateInfoById(Long id ,AlbumUpdateDTO albumUpdateDTO) {
        log.debug("开始执行根据id修改相册详情的业务");
        AlbumStandardVO albumStandardVO = albumMapper.getStandardById(id);
        if (albumStandardVO==null){
            String message = "修改失败,该相册id不存在";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }
        // 检查名称是否被占用
        int count = albumMapper.countByNameAndNotId(id, albumUpdateDTO.getName());
        if (count>0){
            String message ="修改失败,该相册名称已经存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }

        // 将修改的数据复制到Album实体类中
        Album album = new Album();
        BeanUtils.copyProperties(albumUpdateDTO,album);
        album.setId(id);

        int rows = albumMapper.update(album);
        if (rows!=1){
            String message = "修改失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }
    }


    /**
     * 处理查询相册列表的功能
     *
     * @return 返回List集合
     */
    @Override
    public List<AlbumListItemVO> list() {
        log.debug("开始处理[查询相册列表]的功能");
        return albumMapper.list();
    }

    /**
     * 根据id查询相册详情的业务
     * @param id 相册id
     * @return 返回相册详情VO类
     */
    @Override
    public AlbumStandardVO selectById(Long id) {
        log.debug("开始处理根据id:{}查询相册详情的业务",id);
        AlbumStandardVO albumStandardVO =  albumMapper.getStandardById(id);
        if (albumStandardVO==null){
            String message = "查询失败,该id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_SELECT,message);
        }
        return albumStandardVO;
    }
}
