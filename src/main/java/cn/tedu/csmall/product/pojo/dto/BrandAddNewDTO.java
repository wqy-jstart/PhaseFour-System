package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加品牌的DTO类
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Data//该注解在底层会自动实现getter和setter方法,重写equals()和hashCode()方法
public class BrandAddNewDTO implements Serializable {
    private String name;
    private String pinyin;
    private String logo;
    private String description;
    private String keywords;
    private Integer sort;
    private Integer sales;
    private Integer productCount;
    private Integer commentCount;
    private Integer positiveCommentCount;
    private Integer enable;
}
