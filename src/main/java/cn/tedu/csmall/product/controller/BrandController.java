package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.sevice.IBrandService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//接收客户端的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕捉可能发生的异常

/**
 * 控制器对象,处理有关品牌的请求
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Api(tags = "02.品牌管理模块")
@Slf4j
@Validated
@RequestMapping("/Brands")
@RestController
public class BrandController {

    @Autowired//将Service接口注入进来
    private IBrandService brandService;

    //检测控制器是否创建成功?
    public BrandController() {
        log.debug("创建控制器对象:BrandController");
    }

    //http://localhost:8080/Brands/add-NewBrand?name="美的02"&pinyin="新-MeiDi"&logo="新-Mei"&description="新-该商品非常好!"
    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-NewBrand")
    public String addNew2(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理[添加品牌]的请求,参数{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }

    // http://localhost:8080/Brands/id/delete
    @ApiOperation("根据id删除品牌")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@Range(min = 1,message = "删除品牌失败,尝试删除的品牌的ID无效!")
                             @PathVariable Long id) {//接收到的变量值要和路径占位符中的相同
        log.debug("开始处理[根据id删除品牌]的请求,参数:{}",id);
        brandService.delete(id);
        return JsonResult.ok();
    }
}
