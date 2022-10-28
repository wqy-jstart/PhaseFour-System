package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("品牌名称")
    private String name;
    @ApiModelProperty("品牌拼音")
    private String pinyin;
    @ApiModelProperty("品牌logo")
    private String logo;
    @ApiModelProperty("品牌描述")
    private String description;
    @ApiModelProperty("品牌关键字")
    private String keywords;
    @ApiModelProperty("品牌排序")
    private Integer sort;
    @ApiModelProperty("品牌价格")
    private Integer sales;
    @ApiModelProperty("品牌产量")
    private Integer productCount;
    @ApiModelProperty("品牌评论量")
    private Integer commentCount;
    @ApiModelProperty("品牌好评总和")
    private Integer positiveCommentCount;
    @ApiModelProperty("品牌是否启用")
    private Integer enable;
}
