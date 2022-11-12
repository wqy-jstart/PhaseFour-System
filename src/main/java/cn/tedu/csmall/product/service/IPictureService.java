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
     * @param pictureAddNewDTO
     */
    void addNew(PictureAddNewDTO pictureAddNewDTO);
}
