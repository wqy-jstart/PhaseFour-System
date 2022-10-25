package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import org.springframework.stereotype.Repository;

/**
 * 处理相册数据的Mapper接口,该类中的方法不能用重载
 *
 * @Author wqy
 * @Vession 0.0.1
 */
@Repository
public interface AlbumMapper {

    /**
     * 插入相册数据
     *
     * @param album
     * @return int
     */
    int insert(Album album);
}
