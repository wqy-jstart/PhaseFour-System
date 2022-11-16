package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AttributeUpdateInfoDTO;
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

    // http://localhost:9080/attributes/add-New
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

    /**
     * 根据id删除属性的业务
     * @param id 属性id
     * @return JsonResult
     */
    @ApiOperation("根据id删除属性")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "属性id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> deleteById(@PathVariable Long id){
        log.debug("开始处理[根据id删除属性]的请求!");
        attributeService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/attributes/id/update
    @ApiOperation("根据id修改属性")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParam(name = "id",value = "属性id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/update")
    public JsonResult<Void> updateInfoById(@PathVariable Long id ,AttributeUpdateInfoDTO attributeUpdateInfoDTO){
        log.debug("开始处理[根据id{}修改属性]的请求,参数为:{}",id,attributeUpdateInfoDTO);
        attributeService.updateInfoById(id,attributeUpdateInfoDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/attributes/
    @ApiOperation("属性列表")
    @ApiOperationSupport(order = 301)
    @GetMapping("")
    public JsonResult<List<AttributeListItemVO>> list(){
        log.debug("开始处理查询[属性列表]的请求!");
        List<AttributeListItemVO> list = attributeService.list();
        return JsonResult.ok(list);
    }

    // http://localhost:9080/attributes/id/select
    @ApiOperation("根据id查询属性详情")
    @ApiOperationSupport(order = 302)
    @ApiImplicitParam(name = "id",value = "属性id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/select")
    public JsonResult<AttributeStandardVO> selectById(@Range(min = 1,message = "查询失败,该属性id无效!") @PathVariable Long id){
        log.debug("开始处理[根据id查询属性详情]的请求,参数为:{}",id);
        AttributeStandardVO attributeStandardVO = attributeService.selectById(id);
        return JsonResult.ok(attributeStandardVO);
    }

    // http://localhost:9080/templates/id/list
    @ApiOperation("根据模板id查询属性列表")
    @ApiOperationSupport(order = 303)
    @ApiImplicitParam(name = "templateId",value = "模板id",required = true,dataType = "long")
    @GetMapping("/{templateId:[0-9]+}/list")
    public JsonResult<List<AttributeListItemVO>> listByTemplateId(@Range(min = 1,message = "查询失败,该模板id无效!")@PathVariable Long templateId){
        log.debug("开始处理[根据模板id查询属性列表]的请求,参数:{}",templateId);
        List<AttributeListItemVO> listByTemplateId = attributeService.listByTemplate(templateId);
        return JsonResult.ok(listByTemplateId);
    }
}
