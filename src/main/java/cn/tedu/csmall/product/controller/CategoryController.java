package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.sevice.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//该类用来接收客户端传递关于分类的请求,并调用Service实现类中对应的方法来完成数据库对应的操作,并且捕捉可能发生的异常
/**
 * 创建接收分类请求的控制器
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@RestController
public class CategoryController {

    @Autowired//将处理分类的接口注入
    ICategoryService categoryService;

    //检测控制器是否创建成功?
    public CategoryController(){
        log.debug("创建控制器对象:CategoryController");
    }

    //http://localhost:8080/add-newCategory?name="品牌男装7"&parentId=1&depth=1&keywords="无"&sort=0&icon="无"
    @RequestMapping("add-newCategory")
    public String addNew(CategoryAddNewDTO categoryAddNewDTO){
        log.debug("开始处理[添加分类]的请求,参数{}", categoryAddNewDTO);
        try{
            categoryService.addNew(categoryAddNewDTO);
            log.debug("添加数据成功!");
            return "添加数据成功!";
        }catch (ServiceException e){
            String message = e.getMessage();
            log.debug(message);
            return message;
        }catch (RuntimeException e){
            log.debug("添加数据失败！程序运行过程中出现了RuntimeException！");
            return "添加品牌失败！程序运行过程中出现了RuntimeException！";
        } catch (Throwable e) {//非运行时发生的其他所有异常
            log.debug("添加数据失败！程序运行过程中出现了Throwable！");
            return "添加品牌失败！程序运行过程中出现了Throwable！";
        }
    }
}
