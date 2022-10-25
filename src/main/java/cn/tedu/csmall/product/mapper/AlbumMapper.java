package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理相册数据的Mapper接口,该类中的方法建议不用重载
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

    /**
     * 批量插入相册数据
     * @param albums 插入的相册对象
     * @return 返回影响的条数
     */
    int insertBatch(List<Album> albums);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteByIds(Long[] ids);

    /**
     * 根据id修改相册数据
     * @param album 封装了相册id和新数据的对象
     * @return 受影响的行数
     */
    int update(Album album);

    /**
     * 查询相册数据数量
     * @return 返回数据表中的数量
     */
    int count();

    /**
     * 根据id查询相册详情
     * @param id 要查询的相册id
     * @return 匹配的相册详情,如果没有匹配的数据,返回Null
     */
    AlbumStandardVO getStandardById(Long id);
}
