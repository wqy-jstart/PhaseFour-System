package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

@Data
public class CategoryAttributeTemplateAddNewDTO {
    /**
     * 类别id
     */
    private Long categoryId;

    /**
     * 属性模板id
     */
    private Long attributeTemplateId;
}
