package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.CategoryAttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.sevice.ICategoryAttributeTemplateService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "06.分类与属性模板管理模块")
@RequestMapping("/categoryAttributeTemplates")
@RestController
public class CategoryAttributeTemplateController {

    @Autowired
    private ICategoryAttributeTemplateService categoryAttributeTemplateService;

    public CategoryAttributeTemplateController(){
        log.debug("创建控制器对象:CategoryAttributeTemplateController");
    }

    @ApiOperation("添加分类与属性模板")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public String addNew(CategoryAttributeTemplateAddNewDTO categoryAttributeTemplateAddNewDTO){
        log.debug("开始处理[添加分类与属性模板]的请求,参数{}",categoryAttributeTemplateAddNewDTO);
        categoryAttributeTemplateService.addNew(categoryAttributeTemplateAddNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }

    @ApiOperation("根据id删除分类与属性模板")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "分类与属性模板的id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/delete")
    public String delete1(@PathVariable Long id){
        String message = "尝试删除id为["+id+"]的分类与属性模板";
        log.debug(message);
        return message;
    }
}
