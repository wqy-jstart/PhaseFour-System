package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AlbumUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理相册数据的业务接口
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Transactional
public interface IAlbumService {

    /**
     * 该方法用来执行添加相册的功能
     *
     * @param albumAddNewDTO 客户端传递相册数据的DTO对象
     */
    void addNew(AlbumAddNewDTO albumAddNewDTO);

    /**
     * 执行根据id删除相册的功能
     * @param id 需要删除的相册id
     */
    void delete(Long id);

    /**
     * 根据相册id，修改相册详情
     *
     * @param id             相册id
     * @param albumUpdateDTO 新的相册数据
     */
    void updateInfoById(Long id, AlbumUpdateDTO albumUpdateDTO);

    /**
     * 查询所有相册的列表
     *
     * @return
     */
    List<AlbumListItemVO> list();

    /**
     * 根据id查询相册详情
     * @param id 相册id
     * @return 返回相册的详情
     */
    AlbumStandardVO selectById(Long id);
}
