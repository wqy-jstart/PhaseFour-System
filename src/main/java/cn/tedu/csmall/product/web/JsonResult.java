package cn.tedu.csmall.product.web;

import cn.tedu.csmall.product.ex.ServiceException;
import lombok.Data;

import java.io.Serializable;

/**
 * 该类定义统一返回请求结果的方法,JSON对象类型(状态值+结果信息)
 *
 * @Author java@.Wqy
 * @Version 0.0.1
 */
@Data
public class JsonResult implements Serializable {
    //状态码
    private Integer state;
    //描述文本
    private String message;

    /**
     * 成功的静态方法(不用new,直接类名打点调用)
     * @return 返回state状态为1的JsonResult的对象
     */
    public static JsonResult ok(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = ServiceCode.OK.getValue();//直接调用枚举类中OK的状态码value
        return jsonResult;
    }

    public static JsonResult fail(ServiceException e){
        return fail(e.getServiceCode(),e.getMessage());
    }

    /**
     * 错误的静态方法(不用new,直接类名打点调用)
     * @param serviceCode 业务状态码对象
     * @param message 错误信息(原因)
     * @return 返回JsonResult对象(封装了状态码和错误信息)
     */
    public static JsonResult fail(ServiceCode serviceCode,String message){//业务状态码在参数列表中已经被定义
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = serviceCode.getValue();//调用时仅传入枚举属性即可get到value
        jsonResult.message = message;
        return jsonResult;
    }
}
