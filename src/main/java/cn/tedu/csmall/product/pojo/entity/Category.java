package cn.tedu.csmall.product.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Category implements Serializable {
    private Long id;
    private String name;
    @ApiModelProperty(hidden = true)
    private Long parentId;
    @ApiModelProperty(hidden = true)
    private Integer depth;
    private String keywords;
    private Integer sort;
    private String icon;
    @ApiModelProperty(hidden = true)
    private Integer enable;
    @ApiModelProperty(hidden = true)
    private Integer isParent;
    @ApiModelProperty(hidden = true)
    private Integer isDisplay;
    @ApiModelProperty(hidden = true)
    private LocalDateTime gmtCreate;
    @ApiModelProperty(hidden = true)
    private LocalDateTime gmtModified;
}
