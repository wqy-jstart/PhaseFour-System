package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.dto.PictureAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.PictureListItemVO;
import cn.tedu.csmall.product.pojo.vo.PictureStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PictureMapper {

    /**
     * 添加图片数据
     * @param picture 要添加的图片DTO类
     * @return 返回影响的条数
     */
    int insert(Picture picture);

    /**
     * 根据id删除图片
     * @param id 要删除的图片id
     * @return 返回影响的条数
     */
    int delete(Long id);

    /**
     * 根据相册统计图片数据的数量
     * @param albumId 相册id
     * @return 与此相册相关联的数据数量
     */
    int countByAlbumId(Long albumId);

    /**
     * 根据id查询图片详情
     * @param id 要查询的图片id
     * @return 返回查询的图片详情
     */
    PictureStandardVO getStandardById(Long id);

    /**
     * 查询图片列表
     * @return 返回图片列表List集合
     */
    List<PictureListItemVO> list();

}
