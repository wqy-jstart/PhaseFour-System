package cn.tedu.csmall.product.ex;

import cn.tedu.csmall.product.web.ServiceCode;

/**
 * 业务异常,继承自RuntimeException
 *
 * @Author Wqy
 * @Version 0.0.1
 */
public class ServiceException extends RuntimeException {

    private ServiceCode serviceCode;

    /**
     * 以便抛出异常时的状态码和状态描述
     * @param serviceCode 传入ServiceCode枚举类中的状态码赋值给成员变量
     * @param message 抛出异常时反馈的信息
     */
    public ServiceException(ServiceCode serviceCode,String message) {
        super(message);//Throwable类中的构造方法
        this.serviceCode = serviceCode;
    }

    /**
     * 获取业务状态码的方法
     * 当抛出异常时调用ServiceException构造方法,给成员变量赋值
     * @return 返回成员变量业务状态码的实例
     */
    public ServiceCode getServiceCode(){
        return serviceCode;//返回包含状态码的成员变量实例
    }
}
