package cn.tedu.csmall.product.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AlbumListItemVO implements Serializable {
    /**
     * 记录id
     */
    @ApiModelProperty("相册id")
    private Long id;
    /**
     * 相册名称
     */
    @ApiModelProperty("相册名称")
    private String name;
    /**
     * 相册描述
     */
    @ApiModelProperty("相册描述")
    private String description;

    /**
     * 自定义排序序号
     */
    @ApiModelProperty("相册排序")
    private Integer sort;
}
