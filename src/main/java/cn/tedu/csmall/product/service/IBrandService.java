package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandUpdateDTO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理品牌的业务接口
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Transactional
public interface IBrandService {

    /**
     * 该方法用来执行插入品牌数据
     * @param brandAddNewDTO 要插入的品牌DTO对象
     */
    void addNew(BrandAddNewDTO brandAddNewDTO);

    /**
     * 根据id删除品牌
     *
     * @param id 需要删除的品牌id
     */
    void delete(Long id);

    /**
     * 根据品牌id，修改品牌详情
     *
     * @param id             品牌id
     * @param brandUpdateDTO 新的品牌数据
     */
    void updateInfoById(Long id, BrandUpdateDTO brandUpdateDTO);

    /**
     * 查询所有的品牌列表
     * @return List
     */
    List<BrandListItemVO> list();

    /**
     * 根据品牌id查询品牌详情
     * @Param id 品牌id
     * @return 品牌详情
     */
    BrandStandardVO selectById(Long id);

    /**
     * 该方法用于手动重建缓存
     */
    void rebuildCache();

    /**
     * 启用品牌
     * @param id 启用的品牌id
     */
    void setEnable(Long id);

    /**
     * 禁用品牌
     * @param id 禁用的品牌id
     */
    void setDisable(Long id);
}
