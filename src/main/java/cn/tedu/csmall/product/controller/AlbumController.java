package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.sevice.IAlbumService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//接收客户端的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕获可能发生的异常!

/**
 * 控制器对象,处理有关相册的请求
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Api(tags = "01.相册管理模块")
@Slf4j
@Validated
@RequestMapping("/albums")//该Controller类中所有@RequestMapping请求路径的父路径
@RestController
public class AlbumController {

    @Autowired//将Service接口注入进来
    private IAlbumService albumService;

    //检测控制器是否创建成功?
    public AlbumController() {
        log.debug("创建控制器对象:AlbumController");
    }

    // http://localhost:9080/albums/add-new?name=相册001&description=相册001的简介&sort=199
    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    //                     检查传递的参数
    //                       ↓↓↓↓↓↓
    public JsonResult<Void> addNew(@Valid AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        albumService.addNew(albumAddNewDTO);
        log.debug("添加数据成功!");
        return JsonResult.ok();//类名打点调用静态ok()方法
    }

    // http://localhost:9080/albums/id/delete
    @ApiOperation("根据id删除相册")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id", value = "相册id", required = true, dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")//在请求路径中先用占位符进行占位,使用正则来限制输入的内容
    public JsonResult<Void> delete(@Range(min = 1,message = "删除相册失败,尝试删除的相册的ID无效!")
                                   @PathVariable Long id) {//接收路径中通过占位符传入的信息(类型要匹配否则报400)
        log.debug("开始处理[根据id删除相册]的请求,参数:{}",id);
        albumService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/albums
    @ApiOperation("查询相册列表")
    @ApiOperationSupport(order = 410)
    @GetMapping("")
    public JsonResult<List<AlbumListItemVO>> list(){
        log.debug("开始处理[查询相册列表]的请求,无参");
        List<AlbumListItemVO> list = albumService.list();
        return JsonResult.ok(list);//该方法指定了泛型<T>,故要在方法上指定该方法需要返回的泛型
    }
}
