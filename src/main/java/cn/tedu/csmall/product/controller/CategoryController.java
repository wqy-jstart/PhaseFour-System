package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
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
@RequestMapping("/categorys")
@RestController
public class CategoryController {

    @Autowired//将处理分类的接口注入
    private ICategoryService categoryService;

    //检测控制器是否创建成功?
    public CategoryController() {
        log.debug("创建控制器对象:CategoryController");
    }

    // http://localhost:8080/categorys/add-newCategory?name="品牌男装7"&parentId=1&depth=1&keywords="无"&sort=0&icon="无"
    @ApiOperation("添加分类")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-newCategory")
    public JsonResult<Void> addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理[添加分类]的请求,参数{}", categoryAddNewDTO);
        categoryService.addNew(categoryAddNewDTO);
        log.debug("添加数据成功!");
        return JsonResult.ok();
    }

    @ApiOperation("查询分类列表")
    @ApiOperationSupport(order = 200)
    @GetMapping("")
    public JsonResult<List<CategoryListItemVO>> list(){
        log.debug("开始处理查询分类列表的请求");
        List<CategoryListItemVO> list = categoryService.list();
        return JsonResult.ok(list);
    }

    // http://localhost:8080/categorys/id/delete
    @ApiOperation("根据id删除分类")
    @ApiOperationSupport(order = 301)
    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteCategory2(@PathVariable Long id) {
        String message = "尝试删除id为[" + id + "]的分类";
        log.debug(message);
        return message;
    }

    /**
     * 启用分类
     * @param id
     * @return
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
     * @param id
     * @return
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
     * @param id
     * @return
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
     * @param id
     * @return
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
