package cn.tedu.csmall.product.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 创建一个登录当事人对象,封装当事人登录的信息,用来存入上下文
 */
@Data// @Data注解不提供全参构造
@NoArgsConstructor// 无参构造器
@AllArgsConstructor// 全参构造器
public class LoginPrincipal implements Serializable {

    private Long id;
    private String username;

}
