package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestToSQL implements Serializable {

    private Long id;
    private String name;
    private Integer age;
}
