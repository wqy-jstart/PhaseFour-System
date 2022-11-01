package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 添加相册的DTO类
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Data//该注解在底层会自动实现getter和setter方法,重写equals()和hashCode()方法
public class AlbumAddNewDTO implements Serializable {

    /**
     * 相册名称
     */
    @ApiModelProperty(value="相册名称",required = true)//添加required=true后,该属性客户端必须填写
    @NotNull(message = "必须提交相册名称")
    private String name;

    /**
     * 相册简介
     */
    @ApiModelProperty(value="相册描述",required = true)
    @NotNull(message = "必须提交相册简介")
    private String description;

    /**
     * 自定义排序序号
     */
    @ApiModelProperty(value="自定义排序",required = true)
    private Integer sort;
}
