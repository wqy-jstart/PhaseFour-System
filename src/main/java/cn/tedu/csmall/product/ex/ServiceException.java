package cn.tedu.csmall.product.ex;

/**
 * 业务异常,继承自RuntimeException
 *
 * @Author Wqy
 * @Version 0.0.1
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);//Throwable类中的构造方法
    }
}
