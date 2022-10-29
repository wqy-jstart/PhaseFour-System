package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.SkuAddNewDTO;
import cn.tedu.csmall.product.sevice.ISkuService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "09.SKU管理模块")
@Slf4j
@RequestMapping("/sku")
@RestController
public class SkuController {

    @Autowired
    ISkuService skuservice;

    public SkuController(){
        log.debug("创建控制器对象");
    }
    @ApiOperation("添加SKU")
    @ApiOperationSupport(order = 100)
    @GetMapping("/add-New")
    public String addNew(SkuAddNewDTO skuAddNewDTO){
        log.debug("开始处理SKU的请求,参数:{}",skuAddNewDTO);
        skuservice.addNew(skuAddNewDTO);
        String message = "添加数据完成!";
        log.debug(message);
        return message;
    }

    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "title",value = "SKU标题",required = true,dataType = "String")
    @PostMapping("/{title:[a-z]+}/delete")
    public String delete1(@PathVariable String title){
        String message = "尝试处理根据标题["+title+"]删除SKU";
        log.debug(message);
        return message;
    }
}
