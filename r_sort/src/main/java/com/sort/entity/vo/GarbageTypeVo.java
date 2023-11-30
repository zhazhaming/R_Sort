package com.sort.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author changing
 * @create 2022-02-13 20:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GarbageType对象", description="")
public class GarbageTypeVo {

    private static final long serialVersionUID=1L;

    private String name;

    private String gMessage;

    private String gExplain;

    private String contain;

    private String tip;
}
