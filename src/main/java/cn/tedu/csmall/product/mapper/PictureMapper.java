package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.dto.PictureAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.PictureListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PictureMapper {

    int insert(Picture picture);

    int insertBatch(List<Picture> pictures);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(Picture picture);

    int count();

    /**
     * 根据相册统计图片数据的数量
     * @param albumId 相册id
     * @return 与此相册相关联的数据数量
     */
    int countByAlbumId(Long albumId);

    PictureAddNewDTO getStandardById(Long id);

    List<PictureListItemVO> list();
}
