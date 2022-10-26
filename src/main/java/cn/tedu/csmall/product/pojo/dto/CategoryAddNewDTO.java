package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加分类信息的DTO类
 *
 * @Author Wqy
 * @Version 0.0.1
 */
@Data
public class CategoryAddNewDTO implements Serializable {
    private String name;
    private Long parentId;
    private Integer depth;
    private String keywords;
    private Integer sort;
    private String icon;
    private Integer enable;
    private Integer isParent;
    private Integer isDisplay;
}
