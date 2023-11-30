package com.sort.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GarbageEncyclopedia对象", description="")
public class GarbageEncyclopedia implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "garbage_id", type = IdType.AUTO)
    private Integer garbageId;

    @ApiModelProperty(value = "垃圾类别(1其他垃圾，2可回收垃圾，3厨余垃圾，4有害垃圾)")
    private Integer garbageType;

    @ApiModelProperty(value = "垃圾名称")
    private String garbageName;

    @ApiModelProperty(value = "垃圾标语")
    private String remark;


}
