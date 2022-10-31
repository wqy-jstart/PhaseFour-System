package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import cn.tedu.csmall.product.sevice.IAttributeTemplateService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//该Controller用来接收用户传递的属性模板DTO信息,并调用对应接口的实现类处理该请求业务,并且捕获可能产生的异常

/**
 * 创建属性模板控制器
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@Api(tags = "04.属性模板的管理模块")
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

    // http://localhost:8080/AttributeTemplates/name/delete
    @ApiOperation("根据名称删除属性模板")
    @ApiOperationSupport(order = 200)
    @GetMapping("/{name:[a-z]+}/delete")
    public String deleteAT1(@PathVariable String name) {
        String message = "尝试删除名称为[" + name + "],的属性模板";
        log.debug(message);
        return message;
    }

    // http://localhost:8080/AttributeTemplates/id/delete
    @ApiOperation("根据id删除属性模板")
    @ApiOperationSupport(order = 901)
    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteAT2(@PathVariable Long id) {
        String message = "尝试删除id为[" + id + "],的属性模板";
        log.debug(message);
        return message;
    }

    // http://localhost:8080/AttributeTemplates/test/delete
    @ApiOperation("直接删除属性模板")
    @ApiOperationSupport(order = 902)
    @PostMapping("/test/delete")
    public String deleteAT3() {
        String message = "尝试直接删除属性模板";
        log.debug(message);
        return message;
    }
}
