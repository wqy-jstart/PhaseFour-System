package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.service.ICategoryService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//该类用来接收客户端传递关于分类的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕捉可能发生的异常

/**
 * 创建接收分类请求的控制器
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@Api(tags = "03.分类管理模块")
@RequestMapping("/Categorys")
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
    public String addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理[添加分类]的请求,参数{}", categoryAddNewDTO);
        categoryService.addNew(categoryAddNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }

    // http://localhost:8080/categorys/id/delete
    @ApiOperation("根据id删除分类")
    @ApiOperationSupport(order = 901)
    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteCategory2(@PathVariable Long id) {
        String message = "尝试删除id为[" + id + "]的分类";
        log.debug(message);
        return message;
    }
}
