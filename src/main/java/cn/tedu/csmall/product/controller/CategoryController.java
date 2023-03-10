package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.CategoryUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//该类用来接收客户端传递关于分类的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕捉可能发生的异常

/**
 * 创建接收分类请求的控制器
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@Api(tags = "03.分类管理模块")
@RequestMapping("/categories")
@RestController
public class CategoryController {

    @Autowired//将处理分类的接口注入
    private ICategoryService categoryService;

    //检测控制器是否创建成功?
    public CategoryController() {
        log.debug("创建控制器对象:CategoryController");
    }

    // http://localhost:9080/categories/add-newCategory?name="品牌男装7"&parentId=1&depth=1&keywords="无"&sort=0&icon="无"
    @ApiOperation("添加分类")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-newCategory")
    public JsonResult<Void> addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理[添加分类]的请求,参数{}", categoryAddNewDTO);
        categoryService.addNew(categoryAddNewDTO);
        log.debug("添加数据成功!");
        return JsonResult.ok();
    }

    // http://localhost:9080/categories/id/delete
    @ApiOperation("根据id删除分类")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParam(name = "id",value = "要删除的类别id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> deleteById(@Range(min = 1,message = "删除失败,该类别id无效!")@PathVariable Long id) {
        log.debug("开始处理[根据id删除类别]的请求,参数为{}",id);
        categoryService.deleteById(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/categories/id/update
    @ApiOperation("根据id修改分类数据")
    @ApiOperationSupport(order = 301)
    @ApiImplicitParam(name = "id",value = "类别id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/update")
    public JsonResult<Void> update(@PathVariable Long id, CategoryUpdateDTO categoryUpdateDTO){
        log.debug("根据分类id{}修改分类信息",id);
        categoryService.updateInfoById(id,categoryUpdateDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/categories/id/select
    @ApiOperation("根据id查询类别详情")
    @ApiOperationSupport(order = 302)
    @ApiImplicitParam(name = "id",value = "类别id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/select")
    public JsonResult<CategoryStandardVO> selectById(@Range(min = 1,message = "查询失败,该id无效!")@PathVariable Long id){
        log.debug("开始处理根据id:{}查询类别的请求",id);
        CategoryStandardVO categoryStandardVO = categoryService.selectById(id);
        return JsonResult.ok(categoryStandardVO);
    }

    // http://localhost:9080/categories/
    @ApiOperation("查询分类列表")
    @ApiOperationSupport(order = 303)
    @GetMapping("")
    public JsonResult<List<CategoryListItemVO>> list(){
        log.debug("开始处理查询分类列表的请求");
        List<CategoryListItemVO> list = categoryService.list();
        return JsonResult.ok(list);
    }

    // http://localhost:9080/categories/list-by-parent?id=?
    @ApiOperation("根据父级类别查询子级类别")
    @ApiOperationSupport(order = 415)
    @GetMapping("/list-by-parent")
    public JsonResult<List<CategoryListItemVO>> listByParentId(Long parentId){
        log.debug("开始处理[根据父级类别查询自己类别]的请求!");
        List<CategoryListItemVO> list = categoryService.listByParentId(parentId);
        return JsonResult.ok(list);
    }


    /**
     * 启用分类
     * @param id 需要启用的分类id
     * @return JsonResult
     */
    @ApiOperation("启用分类")
    @ApiOperationSupport(order = 500)
    @ApiImplicitParam(name = "id",value = "启用的分类id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/enable")
    public JsonResult<Void> enable(@Range(min = 1,message = "启用分类失败,该id无效!")
                                       @PathVariable Long id){
        log.debug("开始启用分类!");
        categoryService.setEnable(id);
        return JsonResult.ok();
    }

    /**
     * 禁用分类
     * @param id 需要禁用的类别id
     * @return JsonResult
     */
    @ApiOperation("禁用分类")
    @ApiOperationSupport(order = 501)
    @ApiImplicitParam(name = "id",value = "禁用的分类id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/disable")
    public JsonResult<Void> disable(@Range(min = 1,message = "禁用分类失败,该id无效!")
                                        @PathVariable Long id){
        log.debug("开始禁用分类!");
        categoryService.setDisable(id);
        return JsonResult.ok();
    }

    /**
     * 显示分类
     * @param id 需要显示的分类id
     * @return JsonResult
     */
    @ApiOperation("显示分类")
    @ApiOperationSupport(order = 502)
    @ApiImplicitParam(name = "id",value = "显示的分类id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/display")
    public JsonResult<Void> display(@Range(min = 1,message = "显示分类失败,该id无效!")
                                    @PathVariable Long id){
        log.debug("开始显示分类!");
        categoryService.setDisplay(id);
        return JsonResult.ok();
    }

    /**
     * 隐藏分类
     * @param id 需要隐藏的分类id
     * @return JsonResult
     */
    @ApiOperation("隐藏分类")
    @ApiOperationSupport(order = 503)
    @ApiImplicitParam(name = "id",value = "隐藏的分类id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/hidden")
    public JsonResult<Void> hidden(@Range(min = 1,message = "隐藏分类失败,该id无效!")
                                    @PathVariable Long id){
        log.debug("开始隐藏分类!");
        categoryService.setHidden(id);
        return JsonResult.ok();
    }
}
