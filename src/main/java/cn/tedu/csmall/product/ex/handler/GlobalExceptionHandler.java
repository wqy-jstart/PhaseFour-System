package cn.tedu.csmall.product.ex.handler;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.web.JsonResult;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.StringJoiner;

/**
 * 全局异常处理器
 * 该类会使当前项目中,任何标注@RequestMapping处理请求的方法对于ServiceException都应该
 * 是抛出的且各控制器类中都不必关心如何处理ServiceException，会由该类中的相关方法进行处理！
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Slf4j
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler(){
        log.debug("创建全局异常处理器对象：GlobalExceptionHandler");
    }

    /**
     * 自定义异常处理
     * @param e 自定义的异常类
     * @return 返回该异常触发返回的信息
     */
    @ExceptionHandler//此注解会使SpringMVC框架进行统一捕获相同类型的异常
    public JsonResult handlerServiceException(ServiceException e){
        log.debug("开始统一处理ServiceException");
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult handlerBindException(BindException e){//因为该异常的信息不是我们自己定的,而状态信息是我们定的,故调用两参的fail()
        log.debug("开始统一处理BindException");
        StringJoiner stringJoiner = new StringJoiner(",","请求参数格式错误,","!!!");
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError fieldError : fieldErrors){
            String defaultMessage = fieldError.getDefaultMessage();
            stringJoiner.add(defaultMessage);
        }

        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST,stringJoiner.toString());
    }

    /**
     * 全局异常处理
     * @param e 全局的异常类
     * @return 返回异常处理反馈的信息
     */
//    @ExceptionHandler
//    public String handlerServiceException(Throwable e){
//        log.debug("这是一个Throwable异常,将统一处理");
//        return e.getMessage();
//    }
}
