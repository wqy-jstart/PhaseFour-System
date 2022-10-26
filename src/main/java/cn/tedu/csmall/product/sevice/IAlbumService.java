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
     * @param albumAddNewDTO 相册数据DTO
     */
    void addNew(AlbumAddNewDTO albumAddNewDTO);
}
