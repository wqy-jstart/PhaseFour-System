package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.sevice.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//接收客户端的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕获可能发生的异常!

/**
 * 控制器对象,处理有关相册的请求
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@RestController
public class AlbumController {

    @Autowired//将Service接口注入进来
    private IAlbumService albumService;

    //检测控制器是否创建成功?
    public AlbumController() {
        log.debug("创建控制器对象:AlbumController");
    }

    // http://localhost:8080/add-new?name=相册001&description=相册001的简介&sort=199
    //模拟用户访问该地址,并在抽象路径后传递有关相册的参数,传到该Controller中对应方法进行处理
    @RequestMapping("/add-new")
    public String addNew(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        albumService.addNew(albumAddNewDTO);
        log.debug("添加数据成功!");
        return "添加数据成功!";
    }
}
