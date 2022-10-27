package cn.tedu.csmall.product.ex.handler;

import cn.tedu.csmall.product.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * 该类会使当前项目中,任何标注@RequestMapping处理请求的方法对于ServiceException都应该
 * 是抛出的且各控制器类中都不必关心如何处理ServiceException，会由该类中的相关方法进行处理！
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler(){
        log.debug("创建全局异常处理器对象：GlobalExceptionHandler");
    }

    @ExceptionHandler//此注解会使SpringMVC框架进行统一捕获相同类型的异常
    public String handlerServiceException(ServiceException e){
        log.debug("这是请求的方法抛出了ServiceException,将统一处理");
        return e.getMessage();
    }
}
