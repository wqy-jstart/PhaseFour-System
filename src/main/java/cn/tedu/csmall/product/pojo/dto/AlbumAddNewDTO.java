package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

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
    private String name;

    /**
     * 相册简介
     */
    private String description;

    /**
     * 自定义排序序号
     */
    private Integer sort;
}