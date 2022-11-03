package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.service.IAttributeService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/attributes")
@Api(tags = "05.属性管理模块")
public class AttributeController {

    @Autowired
    private IAttributeService attributeService;

    public AttributeController(){
        log.debug("创建控制器对象:AttributeController");
    }

    @ApiOperation("添加属性")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public String addNew(AttributeAddNewDTO attributeAddNewDTO){
        log.debug("开始处理[添加属性]的请求,参数:{}",attributeAddNewDTO);
        attributeService.addNew(attributeAddNewDTO);
        log.debug("添加属性成功");
        return "添加属性成功";
    }

    @ApiOperation("根据id删除属性")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "属性id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/delete")
    public String delete(@PathVariable Long id){
        String message = "尝试删除id值为["+id+"]的相册";
        log.debug(message);
        return message;
    }
}
