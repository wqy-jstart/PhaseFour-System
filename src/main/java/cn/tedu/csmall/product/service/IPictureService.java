package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.PictureAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建图片的Service接口类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Transactional
public interface IPictureService {

    /**
     * 添加图片信息
     * @param pictureAddNewDTO 添加的图片信息DTO类
     */
    void addNew(PictureAddNewDTO pictureAddNewDTO);

    /**
     * 根据id删除图片
     * @param id 要删除的图片id
     */
    void delete(Long id);
}
