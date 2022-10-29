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

    int countByUrl(String url);

    PictureAddNewDTO getStandardById(Long id);

    List<PictureListItemVO> list();
}
