package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.SkuSpecificationAddNewDTO;
import cn.tedu.csmall.product.service.ISkuSpecificationService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "10.SKU数据管理模块")
@Slf4j
@RequestMapping("/skuSpecification")
@RestController
public class SkuSpecificationController {

    @Autowired
    ISkuSpecificationService iSkuSpecificationService;

    public SkuSpecificationController(){
        log.debug("创建控制器对象:SkuSpecificationController");
    }

    @ApiOperation("添加SKU数据")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public String addNew(SkuSpecificationAddNewDTO skuSpecificationAddNewDTO){
        log.debug("开始处理[Sku数据]的请求,参数,{}",skuSpecificationAddNewDTO);
        iSkuSpecificationService.addNew(skuSpecificationAddNewDTO);
        String message = "添加数据成功!";
        log.debug(message);
        return message;
    }

    @ApiOperation("根据skuId删除SKU数据")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "SKU数据的Id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/delete")
    public String delete1(@PathVariable Long id){
        String message = "开始根据SKU数据id["+id+"]进行删除数据";
        log.debug(message);
        return message;
    }
}
