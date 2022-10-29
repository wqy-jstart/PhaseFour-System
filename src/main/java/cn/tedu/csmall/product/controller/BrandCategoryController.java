package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.BrandCategoryAddNewDTO;
import cn.tedu.csmall.product.sevice.IBrandCategoryService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
    @GetMapping("/add-New")
    public String addNew(BrandCategoryAddNewDTO brandCategoryAddNewDTO){
        log.debug("开始处理[品牌分类]的请求,参数{}",brandCategoryAddNewDTO);
        brandCategoryService.addNew(brandCategoryAddNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }

    @ApiOperation("根据id删除品牌分类")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "品牌分类id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public String delete1(@PathVariable Long id){
        String message = "尝试根据id["+id+"]来删除品牌分类";
        log.debug(message);
        return message;
    }
}
