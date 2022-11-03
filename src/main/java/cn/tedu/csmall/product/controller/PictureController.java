package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.PictureAddNewDTO;
import cn.tedu.csmall.product.service.IPictureService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "07.图片管理模块")
@Slf4j
@RequestMapping("/picture")
@RestController
public class PictureController {

    @Autowired
    IPictureService pictureService;

    public PictureController(){
        log.debug("创建控制器对象:PictureController");
    }

    @ApiOperation("添加图片")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public String addNew(PictureAddNewDTO pictureAddNewDTO){
        log.debug("开始处理[添加图片]的请求,参数{}",pictureAddNewDTO);
        pictureService.addNew(pictureAddNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }

    @ApiOperation("根据url删除图片")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "url",value = "图片的Url",required = true,dataType = "string")
    @GetMapping("/{url:[a-z0-9]+}/delete")
    public String delete1(@PathVariable String url){
        String message = "尝试删除url为["+url+"]的图片";
        log.debug(message);
        return message;
    }
}
