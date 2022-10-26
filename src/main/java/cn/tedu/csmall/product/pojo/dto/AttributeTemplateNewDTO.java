package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 上传有关属性和模板的DTO类
 */
@Data
public class AttributeTemplateNewDTO implements Serializable {
    private String name;
    private String pinyin;
    private String keywords;
    private Integer sort;
}
