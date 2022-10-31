package cn.tedu.csmall.product.web;

import lombok.Data;

import java.io.Serializable;

/**
 * 该类会统一返回请求结果,JSON对象类型(状态值+结果信息)
 */
@Data
public class JsonResult implements Serializable {
    private Integer state;
    private String message;
}
