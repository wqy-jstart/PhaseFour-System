package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AttributeAddNewDTO implements Serializable {
    /**
     * 所属属性模板id
     */
    @ApiModelProperty(value = "属性模板的id")
    private Long templateId;

    /**
     * 属性名称
     */
    @ApiModelProperty(value = "属性的名称")
    @NotNull
    private String name;

    /**
     * 简介（某些属性名称可能相同，通过简介补充描述）
     */
    @ApiModelProperty(value = "属性的描述")
    private String description;

    /**
     * 属性类型，1=销售属性，0=非销售属性
     */
    @ApiModelProperty(value = "属性的类型")
    private Integer type;

    /**
     * 输入类型，0=手动录入，1=单选，2=多选， 3=单选（下拉列表），4=多选（下拉列表）
     */
    @ApiModelProperty(value = "属性的输入类型")
    private Integer inputType;

    /**
     * 备选值列表
     */
    @ApiModelProperty(value = "属性的备选值列表")
    private String valueList;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "属性的计量单位")
    private String unit;

    /**
     * 自定义排序序号
     */
    @ApiModelProperty(value = "属性的排序")
    private Integer sort;

    /**
     * 是否允许自定义，1=允许，0=禁止
     */
    @ApiModelProperty(value = "属性的自定义")
    private Integer isAllowCustomize;

}
