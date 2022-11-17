package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.*;
import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Spu;
import cn.tedu.csmall.product.pojo.entity.SpuDetail;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.ISpuService;
import cn.tedu.csmall.product.util.IdUtils;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建SPU的Service接口实现类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class SpuServiceImpl implements ISpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private SpuDetailMapper spuDetailMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private AlbumMapper albumMapper;


    public SpuServiceImpl(){
        log.debug("创建接口实现类:SpuServiceImpl");
    }

    @Override
    public void addNew(SpuAddNewDTO spuAddNewDTO) {
        log.debug("开始处理[添加SPU]的业务,参数,{}",spuAddNewDTO);
        // 根据相册id查询相册详情,检查相册是否存在
        log.debug("检查相册是否存在...");
        AlbumStandardVO albumStandardVO = albumMapper.getStandardById(spuAddNewDTO.getAlbumId());
        if (albumStandardVO==null){
            String message = "添加SPU失败,所选择的相册不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        // 根据品牌id查询品牌详情,检查品牌是否存在
        log.debug("检查品牌是否存在...");
        BrandStandardVO brandStandardVO = brandMapper.getStandardById(spuAddNewDTO.getBrandId());
        if (brandStandardVO==null){
            String message = "添加SPU失败,所选择的品牌不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        // 检查品牌是否已经被禁用
        log.debug("检查品牌是否被禁用...");
        if(brandStandardVO.getEnable()==0){
            String message = "添加SPU失败,所选择的品牌已经被禁用!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        // 根据类别id查询类别详情,检查类别是否存在
        log.debug("检查类别是否存在...");
        CategoryStandardVO categoryStandardVO = categoryMapper.getStandardById(spuAddNewDTO.getCategoryId());
        if (categoryStandardVO==null){
            String message = "添加SPU失败,所选择的类别不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        // 检查类别是否已经被禁用
        log.debug("检查类别是否被禁用...");
        if (categoryStandardVO.getEnable()==0){
            String message = "添加SPU失败,所选择的类别已经被禁用!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        // 检查类别是否没有子级
        log.debug("检查类别是否没有子级...");
        if (categoryStandardVO.getIsParent()==1){
            String message = "添加SPU失败,所选择的类别仍包含子级类别!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        // 创建Spu对象,并将参数对象的属性复制过来
        Spu spu = new Spu();
        BeanUtils.copyProperties(spuAddNewDTO,spu);
        // 补全Spu对象的属性:ID >>> ???
        spu.setId(IdUtils.getId());
        // 补全Spu对象的属性:brandName >>> 前序检查时的查询结果
        spu.setBrandName(brandStandardVO.getName());
        // 补全Spu对象的属性:categoryName >>> 前序检查时的查询结果
        spu.setCategoryName(categoryStandardVO.getName());
        // 补全Spu对象的属性:sales / commentCount / positiveCommentCount >>> 0
        spu.setSales(0);
        spu.setCommentCount(0);
        spu.setPositiveCommentCount(0);
        // 补全Spu对象的属性:isDeleted >>> 0 / isPublished >>> 0 / isChecked >>> 0
        spu.setIsDeleted(0);
        spu.setIsPublished(0);
        spu.setIsChecked(0);
        // 补全Spu对象的属性:isNewArrival >>> 1 / isRecommend >>> 1
        spu.setIsNewArrival(1);
        spu.setIsRecommend(1);
        // 插入Spu数据获取返回值结果并检查
        log.debug("即将插入SPU数据...");
        int rows = spuMapper.insert(spu);
        if (rows>1){
            String message = "添加失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
        // 创建spuDetail对象
        SpuDetail spuDetail = new SpuDetail();
        // 补全spuDetail对象的属性: spuId >>> 以上Spu使用的ID
        spuDetail.setSpuId(IdUtils.getId());
        // 补全SpuDetail对象的属性：detail >>> 来自参数对象
        spuDetail.setDetail(spuAddNewDTO.getDetail());
        // 插入SpuDetail数据，获取返回结果并检查
        log.debug("即将插入SPU详情数据...");
        rows = spuDetailMapper.insert(spuDetail);
        if (rows>1){
            String message = "添加失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
    }
}
