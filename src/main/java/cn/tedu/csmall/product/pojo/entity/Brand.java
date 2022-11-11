package cn.tedu.csmall.product.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Brand implements Serializable {

    private Long id;
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
    @ApiModelProperty(hidden = true)
    private Integer enable;
    @ApiModelProperty(hidden = true)
    private LocalDateTime gmtCreate;
    @ApiModelProperty(hidden = true)
    private LocalDateTime gmtModified;
}
