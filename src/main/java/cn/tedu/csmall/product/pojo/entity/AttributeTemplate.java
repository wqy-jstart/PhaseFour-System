package cn.tedu.csmall.product.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AttributeTemplate implements Serializable {
    private Long id;
    private String name;
    private String pinyin;
    private String keywords;
    private Integer sort;
    @ApiModelProperty(hidden = true)
    private LocalDateTime gmtCreate;
    @ApiModelProperty(hidden = true)
    private LocalDateTime gmtModified;
}
