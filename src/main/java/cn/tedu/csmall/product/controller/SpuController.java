package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import cn.tedu.csmall.product.sevice.ISpuService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "11.SPU管理模块")
@Slf4j
@RequestMapping("/spu")
@RestController
public class SpuController {

    @Autowired
    ISpuService iSpuService;

    public SpuController(){
        log.debug("创建控制器对象:SpuController");
    }

    @ApiOperation("添加SPU")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public String addNew(SpuAddNewDTO spuAddNewDTO){
        log.debug("开始处理[SPU]的请求,参数{}",spuAddNewDTO);
        iSpuService.addNew(spuAddNewDTO);
        String message = "处理SPU插入成功!";
        log.debug(message);
        return message;
    }

    @ApiOperation("根据名称删除SPU")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "name",value = "SPU名称",required = true,dataType = "string")
    @GetMapping("/{name:[a-z]+}/delete")
    public String delete1(@PathVariable String name){
        String message = "尝试删除名称为["+name+"]的SPU";
        log.debug(message);
        return message;
    }
}
