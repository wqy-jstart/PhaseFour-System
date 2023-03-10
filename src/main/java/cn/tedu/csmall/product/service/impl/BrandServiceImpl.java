package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandCategoryMapper;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.mapper.SpuMapper;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.repo.IBrandRedisRepository;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理品牌业务接口的实现类
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandCategoryMapper brandCategoryMapper;

    @Autowired
    private SpuMapper spumapper;

    // 注入品牌的Redis缓存接口
    @Autowired
    private IBrandRedisRepository brandRedisRepository;

    //检测该品牌业务实现类是否创建成功?
    public BrandServiceImpl() {
        log.debug("创建业务对象:BrandServiceImpl");
    }

    /**
     * 实现Service接口中添加品牌的方法
     *
     * @param brandAddNewDTO 要插入的品牌DTO对象
     */
    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理[添加品牌]的业务,参数{}", brandAddNewDTO);
        //从参数对象中获取DTO对象的名称
        String brandName = brandAddNewDTO.getName();
        //检查相册名称是否已经被占用(相册表中是否已经存在此名称的数据)
        log.debug("检查品牌名称是否已经被占用");
        int count = brandMapper.countByName(brandName);
        if (count > 0) {
            String message = "添加品牌失败,品牌名称已经被占用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        log.debug("品牌名称没有被占用,将向品牌表中插入数据");
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        log.debug("即将插入相册数据:{}", brand);
        int rows = brandMapper.insert(brand);
        if (rows != 1) {// 如果插入所影响的行数不为1
            String message = "插入品牌失败,服务器忙,请稍后再尝试!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
        log.debug("插入品牌数据完成!");
    }

    /**
     * 处理根据id删除品牌的业务
     *
     * @param id 需要删除的品牌id
     */
    @Override
    public void delete(Long id) {
        log.debug("开始处理根据id:[{}]删除品牌的业务", id);
        //根据id查询信息
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        if (queryResult == null) {
            String message = "删除失败,没有该id下的品牌数据";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 检查是否存在与品牌分类关联的数据,如果存在则不能删除
        {
            int count = brandCategoryMapper.countByBrandId(id);
            if (count > 0) {
                String message = "删除品牌失败,此品牌存在关联品牌分类的数据";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        // 检查是否存在与SPU关联的数据,如果存在则不能删除
        {
            int count = spumapper.countByBrandId(id);
            if (count > 0) {
                String message = "删除品牌失败,此品牌存在关联SPU的数据";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        }

        log.debug("开始执行删除品牌功能");
        int rows = brandMapper.deleteById(id);
        if (rows != 1) {// 如果插入所影响的行数不为1
            String message = "删除品牌失败,服务器忙,请稍后再尝试!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
        log.debug("删除品牌数据完成!");
    }

    /**
     * 根据id修改品牌数据
     *
     * @param id             品牌id
     * @param brandUpdateDTO 新的品牌数据
     */
    @Override
    public void updateInfoById(Long id, BrandUpdateDTO brandUpdateDTO) {
        log.debug("开始处理根据id修改品牌的业务,参数:{}", id);
        BrandStandardVO brandStandardVO = brandMapper.getStandardById(id);
        if (brandStandardVO == null) {
            String message = "修改品牌详情失败，尝试访问的数据不存在！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        int count = brandMapper.countByNameAndNotId(id, brandUpdateDTO.getName());
        if (count > 0) {
            String message = "修改品牌详情失败，品牌名称已经被占用！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateDTO, brand);
        brand.setId(id);

        // 修改数据
        log.debug("即将修改数据：{}", brand);
        int rows = brandMapper.update(brand);
        if (rows > 1) {
            String message = "修改失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }

    /**
     * 执行查询所有品牌列表的业务
     *
     * @return List
     */
    @Override
    public List<BrandListItemVO> list() {
        log.debug("开始执行[查询品牌列表]的业务,无参数");
        return brandRedisRepository.list();// 从Redis中查询列表
    }

    /**
     * 执行根据id查询品牌的业务
     *
     * @param id 品牌id
     * @return 返回品牌业务的Vo类
     */
    @Override
    public BrandStandardVO selectById(Long id) {
        log.debug("开始根据品牌id:{}来查询品牌详情的业务", id);
        // 根据id从缓存中获取数据
        log.debug("将从Redis中获取相关数据");
        BrandStandardVO brand = brandRedisRepository.get(id);
        // 判断获取到的结果是否不为null
        if (brand != null) {
            // 是:直接返回
            log.debug("命中缓存,即将返回:{}", brand);
            return brand;
        }
        // 无缓存数据,从数据库中查找数据
        log.debug("未命中缓存,即将向数据库中查询数据");
        brand = brandMapper.getStandardById(id);
        // 判断查询到的结果是否为null
        if (brand == null) {
            // 是:抛出异常
            String message = "查询失败,尝试访问的数据不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        // 将查询结果写入到缓存,并返回
        log.debug("从数据库中查询到有效结果,将查询结果存入到Redis中:{}", brand);
        brandRedisRepository.save(brand);
        log.debug("开始返回结果!");
        return brand;
    }

    /**
     * 手动重建Redis缓存的方法
     */
    @Override
    public void rebuildCache() {
        log.debug("准备删除Redis缓存中的品牌数据...");
        brandRedisRepository.deleteAll();// 清除缓存中的数据,防止缓存堆积过多,显示的列表数据冗余
        log.debug("删除Redis缓存中的品牌数据,完成!");

        log.debug("准备从数据库中读取品牌列表...");
        List<BrandListItemVO> list = brandMapper.list(); // 利用Mapper查询列表放到List中
        log.debug("从数据库中读取品牌列表，完成！");

        log.debug("准备将品牌列表写入到Redis缓存...");
        brandRedisRepository.save(list);// 利用品牌的Redis接口调用save转入要保存的列表,加载到缓存中
        log.debug("将品牌列表写入到Redis缓存，完成！");

        log.debug("准备将各品牌详情写入Redis缓存...");
        for (BrandListItemVO brandListItemVO : list) {// 遍历拿到的品牌列表
            Long id = brandListItemVO.getId();// 获取遍历的每个品牌列表的id
            BrandStandardVO brandStandardVO = brandMapper.getStandardById(id);// 利用拿到的id来查询对应的品牌详情
            brandRedisRepository.save(brandStandardVO);// 将每一个品牌详情放到Redis缓存中
        }
        log.debug("将各品牌详情写入到Redis缓存中,完成!");
    }

    /**
     * 处理启用品牌的业务
     *
     * @param id 启用的品牌id
     */
    @Override
    public void setEnable(Long id) {
        updateEnableById(id, 1);
    }

    /**
     * 处理禁用品牌的业务
     *
     * @param id 禁用的品牌id
     */
    @Override
    public void setDisable(Long id) {
        updateEnableById(id, 0);
    }

    /**
     * 该方法用来处理启用与禁用功能的逻辑
     *
     * @param id     需要操作的品牌id
     * @param enable 是否启用或禁用
     */
    private void updateEnableById(Long id, Integer enable) {
        String[] tips = {"禁用", "启用"};
        log.debug("开始处理[{}品牌]的业务,id参数为{}", tips[enable], id);
        // 根据id查询管理员详情
        BrandStandardVO brandStandardVO = brandMapper.getStandardById(id);
        if (brandStandardVO == null) {
            String message = tips[enable] + "品牌失败,尝试访问的数据不存在！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        // 判断查询结果中的enable与方法参数enable是否相同
        if (enable.equals(brandStandardVO.getEnable())) {
            String message = tips[enable] + "品牌失败，管理员账号已经处于" + tips[enable] + "状态！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        // 创建admin对象,并封装id和enable这2个属性的值,并进行修改
        Brand brand = new Brand();
        brand.setId(id);
        brand.setEnable(enable);
        int rows = brandMapper.update(brand);
        if (rows != 1) {
            String message = tips[enable] + "管理员失败，服务器忙，请稍后再次尝试！";
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
        log.debug("修改成功!");
    }
}
