package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateNewDTO;
import cn.tedu.csmall.product.sevice.IAttributeTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//该Controller用来接收用户传递的属性模板DTO信息,并调用对应接口的实现类处理该请求业务,并且捕获可能产生的异常
/**
 * 创建属性模板控制器
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@RestController
public class AttributeTemplateController {

    @Autowired
    IAttributeTemplateService attributeTemplateService;

    //检测控制类对象是否创建成功!
    public AttributeTemplateController(){
        log.debug("创建控制类对象:AttributeTemplateController");
    }

    // http://localhost:8080/add-newAT?name=不知道8&pinyin=bzd&keywords=无&sort=1
    @RequestMapping("add-newAT")
    public String addNew(AttributeTemplateNewDTO attributeTemplateNewDTO){
        log.debug("开始处理【添加属性模板】的请求，参数：{}", attributeTemplateNewDTO);

        try{
            attributeTemplateService.addNew(attributeTemplateNewDTO);
            log.debug("添加数据成功!");
            return "添加数据成功!";
        }catch (ServiceException e){
            String message = e.getMessage();
            log.debug(message);
            return message;
        }catch (RuntimeException e){
            log.debug("添加数据失败！程序运行过程中出现了RuntimeException！");
            return "添加相册失败！程序运行过程中出现了RuntimeException！";
        }catch (Throwable e){//非运行时发生的其他所有异常
            log.debug("添加数据失败！程序运行过程中出现了Throwable！");
            return "添加相册失败！程序运行过程中出现了Throwable！";
        }
    }
}
