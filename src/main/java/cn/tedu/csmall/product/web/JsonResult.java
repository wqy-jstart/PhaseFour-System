package cn.tedu.csmall.product.web;

import lombok.Data;

import java.io.Serializable;

/**
 * 该类会统一返回请求结果,JSON对象类型(状态值+结果信息)
 */
@Data
public class JsonResult implements Serializable {
    //状态码
    private Integer state;
    //描述文本
    private String message;

    public JsonResult(){

    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    /**
     * 成功的静态方法(不用new,直接类名打点调用)
     * @return 返回state状态为1的JsonResult的对象
     */
    public static JsonResult ok(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = 1;
        return jsonResult;
    }

    /**
     * 错误的静态方法(不用new,直接类名打点调用)
     * @param state 错误的状态码
     * @param message 错误信息(原因)
     * @return 返回JsonResult对象(封装了状态码和错误信息)
     */
    public static JsonResult fail(Integer state,String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = state;
        jsonResult.message = message;
        return jsonResult;
    }
}
