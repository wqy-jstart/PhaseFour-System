package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.sevice.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//接收客户端的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕捉可能发生的异常
/**
 * 控制器对象,处理有关品牌的请求
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@RestController
public class BrandController {

    @Autowired//将Service接口注入进来
    private IBrandService brandService;

    //检测控制器是否创建成功?
    public BrandController() {
        log.debug("创建控制器对象:BrandController");
    }

    //http://localhost:8080/add-NewBrand?name="美的02"&pinyin="新-MeiDi"&logo="新-Mei"&description="新-该商品非常好!"
    @RequestMapping("add-NewBrand")
    public String addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理[添加品牌]的请求,参数{}", brandAddNewDTO);
        try {
            brandService.addNew(brandAddNewDTO);
            log.debug("添加数据成功!");
            return "添加数据成功!";
        } catch (ServiceException e) {
            String message = e.getMessage();
            log.debug(message);
            return message;
        } catch (RuntimeException e) {//运行时发生的其他异常
            log.debug("添加数据失败！程序运行过程中出现了RuntimeException！");
            return "添加品牌失败！程序运行过程中出现了RuntimeException！";
        } catch (Throwable e) {//非运行时发生的其他所有异常
            log.debug("添加数据失败！程序运行过程中出现了Throwable！");
            return "添加品牌失败！程序运行过程中出现了Throwable！";
        }
    }
}
