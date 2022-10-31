package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.SpuDetailAddNewDTO;
import cn.tedu.csmall.product.sevice.ISpuDetailService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "12.SPU详情管理模块")
@Slf4j
@RequestMapping("/spuDetail")
@RestController
public class SpuDetailController {

    @Autowired
    ISpuDetailService iSpuDetailService;

    public SpuDetailController(){
        log.debug("创建控制器对象:SpuDetailController");
    }

    @ApiOperation("添加SPU详情")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public String addNew(SpuDetailAddNewDTO spuDetailAddNewDTO){
        log.debug("开始处理[SPU详情]的请求,参数{}",spuDetailAddNewDTO);
        iSpuDetailService.addNew(spuDetailAddNewDTO);
        String message = "添加SPU详情成功!";
        log.debug(message);
        return message;
    }

    @ApiOperation("根据spuId删除SPU详情")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "SPU的id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/delete")
    public String delete1(@PathVariable Long id){
        String message = "尝试删除spuId为["+id+"]的SPU详情";
        log.debug(message);
        return message;
    }
}
