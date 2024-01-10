package com.sort.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.security.auth.Subject;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Volunteer对象", description="")
@TableName("volunteer")
public class Volunteer implements Serializable {

    @TableField("id")
    @NotNull
    private int id;

    @TableField("missionId")
    @NotNull
    private int missionId;

    @TableField("districtName")
    private String districtName;

    @TableField("subject")
    private String subject;

    @TableField("startDate")
    private Date startDate;

    @TableField("endDate")
    private Date endDate;

    @TableField("missionTypeName")
    private String missionTypeName;

    @TableField("missionRegionName")
    private String missionRegionName;

    @TableField("url")
    private String url;



}
