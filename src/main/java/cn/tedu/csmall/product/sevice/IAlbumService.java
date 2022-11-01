package cn.tedu.csmall.product.sevice;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;

/**
 * 处理相册数据的业务接口
 *
 * @Author Wqy
 * @Version 0.0.1
 */
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
}
