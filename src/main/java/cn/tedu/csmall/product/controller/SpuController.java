package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import cn.tedu.csmall.product.service.ISpuService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "11.SPU管理模块")
@Slf4j
@RequestMapping("/spu")
@RestController
public class SpuController {

    @Autowired
    ISpuService SpuService;

    public SpuController() {
        log.debug("创建控制器对象:SpuController");
    }

    @ApiOperation("添加SPU")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public JsonResult<Void> addNew(@Valid SpuAddNewDTO spuAddNewDTO) {
        log.debug("开始处理[添加SPU]的请求,参数{}", spuAddNewDTO);
        SpuService.addNew(spuAddNewDTO);
        return JsonResult.ok();
    }
}
