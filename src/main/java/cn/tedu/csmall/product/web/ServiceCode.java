package cn.tedu.csmall.product.web;

/**
 * 业务状态码
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
public enum ServiceCode {

    // 使用枚举中的常量时相当于调用枚举的构造方法 例:OK()
    /**
     * 成功
     */
    OK(20000),

    /**
     * 错误:检查参数产生的错误
     */
    ERR_BAD_REQUEST(40000),

    /**
     * 错误:数据不存在
     */
    ERROR_CONFLICT(40400),

    /**
     * 错误:数据冲突
     */
    ERR_NOT_FOUND(40900);

    private Integer value;

    private ServiceCode(Integer value){//构造方法传入value赋值给变量this.value
        this.value = value;
    }

    public Integer getValue(){//提供get方法调用时获取对应枚举的value并返回
        return value;
    }
}
