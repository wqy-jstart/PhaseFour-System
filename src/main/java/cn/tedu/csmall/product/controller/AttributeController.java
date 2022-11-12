package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import cn.tedu.csmall.product.service.IAttributeService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Validated
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
    public JsonResult<Void> addNew(@Valid AttributeAddNewDTO attributeAddNewDTO){
        log.debug("开始处理[添加属性]的请求,参数:{}",attributeAddNewDTO);
        attributeService.addNew(attributeAddNewDTO);
        String message = "添加属性成功!";
        log.debug(message);
        return JsonResult.ok();
    }

    // http://localhost:9080/attributes/update
    @ApiOperation("根据id修改属性")
    @ApiOperationSupport(order = 300)
    @PostMapping("/update")
    public JsonResult<Void> update(Attribute attribute){
        log.debug("开始处理[根据id{}修改属性]的请求,参数为:{}",attribute.getId(),attribute);
        attributeService.update(attribute);
        return JsonResult.ok();
    }

    @ApiOperation("属性列表")
    @ApiOperationSupport(order = 301)
    @GetMapping("")
    public JsonResult<List<AttributeListItemVO>> list(){
        log.debug("开始处理查询[属性列表]的请求!");
        List<AttributeListItemVO> list = attributeService.list();
        return JsonResult.ok(list);
    }

    @ApiOperation("根据id查询属性详情")
    @ApiOperationSupport(order = 302)
    @ApiImplicitParam(name = "id",value = "属性id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/select")
    public JsonResult<AttributeStandardVO> selectById(@Range(min = 1,message = "查询失败,该属性id无效!") @PathVariable Long id){
        log.debug("开始处理[根据id查询属性详情]的请求,参数为:{}",id);
        AttributeStandardVO attributeStandardVO = attributeService.selectById(id);
        return JsonResult.ok(attributeStandardVO);
    }

//    @ApiOperation("根据id删除属性")
//    @ApiOperationSupport(order = 901)
//    @ApiImplicitParam(name = "id",value = "属性id",required = true,dataType = "long")
//    @GetMapping("/{id:[0-9]+}/delete")
//    public JsonResult delete(@PathVariable Long id){
//        String message = "尝试删除id值为["+id+"]的相册";
//        log.debug(message);
//        return JsonResult.ok();
//    }
}
