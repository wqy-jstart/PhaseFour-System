package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.BrandCategoryAddNewDTO;
import cn.tedu.csmall.product.service.IBrandCategoryService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 创建处理品牌分类的控制器
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Api(tags = "08.品牌分类管理模块")
@Slf4j
@RequestMapping("/brandCategory")
@RestController
public class BrandCategoryController {

    @Autowired
    IBrandCategoryService brandCategoryService;

    public BrandCategoryController(){
        log.debug("创建控制器对象:BrandCategoryController");
    }

    @ApiOperation("添加品牌分类")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public JsonResult<Void> addNew(BrandCategoryAddNewDTO brandCategoryAddNewDTO){
        log.debug("开始处理[品牌分类]的请求,参数{}",brandCategoryAddNewDTO);
        brandCategoryService.addNew(brandCategoryAddNewDTO);
        log.debug("添加数据成功!");
        return JsonResult.ok();
    }

    @ApiOperation("根据id删除品牌分类")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brandId",value = "品牌id",required = true,dataType = "long"),
            @ApiImplicitParam(name = "categoryId",value = "类别id",required = true,dataType = "long")
    })
    @GetMapping("/{brandId:[0-9]+}/{categoryId:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long brandId,@PathVariable Long categoryId){
        log.debug("开始处理根据品牌id:{}和类别id:{}删除关联表绑定的数据",brandId,categoryId);
        brandCategoryService.delete(brandId,categoryId);
        return JsonResult.ok();
    }
}
