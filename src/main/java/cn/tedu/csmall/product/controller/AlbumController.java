package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.sevice.IAlbumService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//接收客户端的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕获可能发生的异常!

/**
 * 控制器对象,处理有关相册的请求
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Api(tags = "01.相册管理模块")
@Slf4j
@RequestMapping("/albums")//该Controller类中所有@RequestMapping请求路径的父路径
@RestController
public class AlbumController {

    @Autowired//将Service接口注入进来
    private IAlbumService albumService;

    //检测控制器是否创建成功?
    public AlbumController() {
        log.debug("创建控制器对象:AlbumController");
    }

    // http://localhost:8080/albums/add-new?name=相册001&description=相册001的简介&sort=199
    //模拟用户访问该地址,并在抽象路径后传递有关相册的参数,传到该Controller中对应方法进行处理
    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    @GetMapping("/add-new")
    public String addNew(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        albumService.addNew(albumAddNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }

    // http://localhost:8080/albums/233/delete
    @ApiOperation("根据id删除相册")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id", value = "相册id", required = true, dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")//在请求路径中先用占位符进行占位,使用正则来限制输入的内容
    public String deleteAlbum2(@PathVariable Long id) {//接收路径中通过占位符传入的信息(类型要匹配否则报400)
        String message = "尝试删除id为[" + id + "]的相册";
        log.debug(message);//输出日志
        return message;//向客户端返回结果
    }

    // http://localhost:8080/albums/name/sort/delete
    @ApiOperation("【已过期】根据名称删除相册")
    @ApiOperationSupport(order = 901)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "相册名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "相册排序", required = true, dataType = "int")
    })
    @PostMapping("/{name:[a-z]+}/{sort:[a-z]+}/delete")//在请求路径中先用占位符进行占位
    public String deleteAlbum1(@PathVariable String name,@PathVariable Integer sort) {//接收路径中通过占位符传入的信息(类型要匹配否则报400)
        String message = "尝试删除名称为[" + name + "],排序为[" + sort + "]的相册";
        log.debug(message);//输出日志
        return message;//向客户端返回结果
    }

    // http://localhost:8080/albums/test/delete
    @ApiOperation("【已过期】直接发出删除请求")
    @ApiOperationSupport(order = 902)
    @PostMapping("/test/delete")
    public String deleteAlbum3() {
        String message = "尝试测试删除相册";
        log.debug(message);
        return message;
    }
}
