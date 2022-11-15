package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//接收客户端的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕捉可能发生的异常

/**
 * 控制器对象,处理有关品牌的请求
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Api(tags = "02.品牌管理模块")
@Slf4j
@Validated
@RequestMapping("/brands")
@RestController
public class BrandController {

    @Autowired//将Service接口注入进来
    private IBrandService brandService;

    //检测控制器是否创建成功?
    public BrandController() {
        log.debug("创建控制器对象:BrandController");
    }

    /**
     * 处理添加品牌的请求
     * @param brandAddNewDTO 客户端传递的品牌信息
     * @return JsonResult
     */
    //http://localhost:9080/brands/add-NewBrand?name="美的02"&pinyin="新-MeiDi"&logo="新-Mei"&description="新-该商品非常好!"
    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-NewBrand")
    public JsonResult<Void> addNew2(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理[添加品牌]的请求,参数{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        log.debug("添加数据成功!");
        return JsonResult.ok();
    }

    /**
     * 处理根据id删除品牌的请求
     * @param id 要删除的品牌id
     * @return JsonResult
     */
    // http://localhost:9080/brands/id/delete
    @ApiOperation("根据id删除品牌")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@Range(min = 1,message = "删除品牌失败,尝试删除的品牌的ID无效!")
                             @PathVariable Long id) {//接收到的变量值要和路径占位符中的相同
        log.debug("开始处理[根据id删除品牌]的请求,参数:{}",id);
        brandService.delete(id);
        return JsonResult.ok();
    }

    /**
     * 根据id修改品牌数据
     * @param id 品牌id
     * @param brandUpdateDTO 要修改的品牌DTO类
     * @return JsonResult
     */
    // http://localhost:9080/brands/update
    @ApiOperation("根据id修改品牌数据")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParam(name = "id",value = "品牌id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/update")
    public JsonResult<Void> updateInfoById(@PathVariable Long id, BrandUpdateDTO brandUpdateDTO){
        log.debug("开始处理[根据id修改品牌数据的请求],id为{}",id);
        brandService.updateInfoById(id,brandUpdateDTO);
        return JsonResult.ok();
    }

    /**
     * 处理查询品牌列表的请求
     * @return JsonResult
     */
    // http://localhost:9080/brands
    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 301)
    @GetMapping("")
    public JsonResult<List<BrandListItemVO>> list(){
        log.debug("开始处理[查询品牌列表]的请求,无参");
        List<BrandListItemVO> list = brandService.list();
        return JsonResult.ok(list);
    }

    // http://localhost:9080/brands/id/select
    @ApiOperation("根据id查询品牌数据")
    @ApiOperationSupport(order = 302)
    @ApiImplicitParam(name = "id",value = "品牌id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/select")
    public JsonResult<BrandStandardVO> selectById(@Range(min = 1,message = "查询失败,该id无效!")@PathVariable Long id){
        log.debug("开始处理[根据id{}查询品牌详情]的请求",id);
        BrandStandardVO brandStandardVO = brandService.selectById(id);
        return JsonResult.ok(brandStandardVO);
    }

    // http://localhost:9080/brands/chche/rebuild
    @ApiOperation("重建品牌缓存")
    @ApiOperationSupport(order = 600)
    @PostMapping("/cache/rebuild")
    public JsonResult<Void> rebuildCache(){
        log.debug("开始处理[重建缓存]的请求,无参数");
        brandService.rebuildCache();
        return JsonResult.ok();
    }

    /**
     * 处理启用品牌的请求
     * @param id 要启用的品牌id
     * @return JsonResult
     */
    // http://localhost:9080/brands/id/enable
    @ApiOperation("启用品牌")
    @ApiOperationSupport(order = 500)
    @ApiImplicitParam(name = "id",value = "启用的品牌id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/enable")
    public JsonResult<Void> enable(@Range(min = 1,message = "启用品牌失败,尝试启用的id无效!")
                                 @PathVariable Long id){
        log.debug("开始将id为{}的管理员设置为启用状态",id);
        brandService.setEnable(id);
        return JsonResult.ok();
    }

    /**
     * 处理禁用品牌的请求
     * @param id 要禁用的品牌id
     * @return JsonResult
     */
    // http://localhost:9080/brands/id/disable
    @ApiOperation("禁用品牌")
    @ApiOperationSupport(order = 501)
    @ApiImplicitParam(name = "id",value = "禁用的品牌id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/disable")
    public JsonResult<Void> disable(@PathVariable Long id){
        log.debug("开始将id为{}的品牌设置为禁用状态",id);
        brandService.setDisable(id);
        return JsonResult.ok();
    }
}
