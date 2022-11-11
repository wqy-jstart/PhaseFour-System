package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
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

import java.util.List;
//该Controller用来接收用户传递的属性模板DTO信息,并调用对应接口的实现类处理该请求业务,并且捕获可能产生的异常

/**
 * 创建属性模板控制器
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@Api(tags = "04.属性模板的管理模块")
@Validated
@RequestMapping("/AttributeTemplates")
@RestController
public class AttributeTemplateController {

    @Autowired
    IAttributeTemplateService attributeTemplateService;

    //检测控制类对象是否创建成功!
    public AttributeTemplateController() {
        log.debug("创建控制类对象:AttributeTemplateController");
    }

    // http://localhost:8080/AttributeTemplates/add-newAT?name=不知道8&pinyin=bzd&keywords=无&sort=1
    @ApiOperation("添加属性模板")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public String addNew(AttributeTemplateNewDTO attributeTemplateNewDTO) {
        log.debug("开始处理【添加属性模板】的请求，参数：{}", attributeTemplateNewDTO);
        attributeTemplateService.addNew(attributeTemplateNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }

    // http://localhost:8080/AttributeTemplates/id/delete
    @ApiOperation("根据id删除属性模板")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> deleteAT2(@Range(min = 1,message = "删除属性模板失败,尝试删除的属性模板的ID无效!")
                                    @PathVariable Long id) {
        log.debug("开始删除id为[" + id + "],的属性模板");
        attributeTemplateService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/AttributeTemplates/update
    @ApiOperation("根据id修改属性模板")
    @ApiOperationSupport(order = 300)
    @PostMapping("/update")
    public JsonResult<Void> update(AttributeTemplate attributeTemplate){
        log.debug("开始处理[根据id修改属性模板]的请求,参数:{}",attributeTemplate.getId());
        attributeTemplateService.update(attributeTemplate);
        return JsonResult.ok();
    }

    // http://localhost:9080/AttributeTemplates
    @ApiOperation("属性模板列表")
    @ApiOperationSupport(order = 301)
    @GetMapping("")
    public JsonResult<List<AttributeTemplateListItemVO>> list(){
        log.debug("开始处理[属性模板列表]的请求");
        List<AttributeTemplateListItemVO> list = attributeTemplateService.list();
        return JsonResult.ok(list);
    }
    // http://localhost:9080/AttributeTemplates/id/select
    @ApiOperation("根据id查询属性模板的详情")
    @ApiOperationSupport(order = 302)
    @ApiImplicitParam(name = "id",value = "属性模板id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/select")
    public JsonResult<AttributeTemplateStandardVO> selectById(@Range(min = 1,message = "查询失败,该属性模板id无效!")@PathVariable Long id){
        log.debug("开始处理[根据id查询属性模板]的请求");
        AttributeTemplateStandardVO attributeTemplateStandardVO = attributeTemplateService.selectById(id);
        return JsonResult.ok(attributeTemplateStandardVO);
    }
}
