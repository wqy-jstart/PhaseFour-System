package cn.tedu.csmall.product.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 这是一个切面类,主要统计整个执行流程中Service层的耗时
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Aspect // 声明是一个切面类
@Component // 声明是一个组件类,项目启动时被加载
public class TimerAspect {

    public TimerAspect() {
        log.debug("创建切面对象:TimerAspect");
    }

    // @Around注解表示“包裹”，通常也称之为“环绕”
    // @Around注解中的execution内部配置表达式，以匹配上需要哪里执行切面代码
    // 表达式中，星号（*）是通配符，可匹配1次任意内容
    // 表达式中，2个连接的小数点（..）也是通配符，可匹配0~n次，只能用于包名和参数列表
    @Around("execution(* cn.tedu.csmall.product.service.*.*(..))")
    //                 ↑ 此星号表示需要匹配的方法的返回值类型
    //                   ↑ ---------- 根包 ----------- ↑
    //                                                  ↑ 类名
    //                                                    ↑ 方法名
    //                                                      ↑↑ 参数列表
    public Object a(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("执行了TimeAspect中的方法...");

        String className = pjp.getTarget().getClass().getName();// 获取执行的类对象名称
        String signatureName = pjp.getSignature().getName();// 获取执行的方法签名
        Object[] methodArgs = pjp.getArgs();// 获取执行的参数值
        log.debug("【{}】类型的对象调用了【{}】方法,参数值为【{}】", className, signatureName, methodArgs);

        long start = System.currentTimeMillis();
        // ★注意:必须获取调用此方法的返回值,作为当前切面方法的返回值
        // ★注意:必须抛出调用此方法的异常,不可以使用try...catch捕获并处理
        Object result = pjp.proceed();// 相当于执行了匹配的Service方法,业务方法
        long end = System.currentTimeMillis();

        log.debug("执行耗时:{}ms", end - start);

        return result;// 将获取的业务类结果返回
    }
}
