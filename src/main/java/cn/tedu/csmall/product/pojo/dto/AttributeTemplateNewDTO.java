package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 上传有关属性和模板的DTO类
 */
@Data
public class AttributeTemplateNewDTO implements Serializable {

    @ApiModelProperty(value = "属性模板的名称")
    private String name;
    @ApiModelProperty(value = "属性模板的拼音")
    private String pinyin;
    @ApiModelProperty(value = "属性模板的关键字")
    private String keywords;
    @ApiModelProperty(value = "属性模板的排序")
    private Integer sort;
}
