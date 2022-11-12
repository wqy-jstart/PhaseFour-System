package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.PictureAddNewDTO;
import cn.tedu.csmall.product.service.IPictureService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "07.图片管理模块")
@Slf4j
@RequestMapping("/picture")
@RestController
public class PictureController {

    @Autowired
    IPictureService pictureService;

    public PictureController() {
        log.debug("创建控制器对象:PictureController");
    }

    /**
     * 添加图片数据
     * @param pictureAddNewDTO 需要添加的图片数据DTO类
     * @return JsonResult
     */
    @ApiOperation("添加图片")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-New")
    public JsonResult<Void> addNew(PictureAddNewDTO pictureAddNewDTO) {
        log.debug("开始处理[添加图片]的请求,参数{}", pictureAddNewDTO);
        pictureService.addNew(pictureAddNewDTO);
        return JsonResult.ok();
    }

    /**
     * 根据id删除图片
     * @param id 要删除的图片id
     * @return 返回JsonResult
     */
    @ApiOperation("根据id删除图片")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id", value = "图片的id", required = true, dataType = "long")
    @GetMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete1(@PathVariable Long id) {
        log.debug("开始删除id为:{}的图片", id);
        pictureService.delete(id);
        return JsonResult.ok();
    }
}
