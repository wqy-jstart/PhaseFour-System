package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("类别名称")
    private String name;
    @ApiModelProperty("父级类别")
    private Long parentId;
    @ApiModelProperty("关键字")
    private String keywords;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("是否启用")
    private Integer enable;
    @ApiModelProperty("是否显示")
    private Integer isDisplay;
}
