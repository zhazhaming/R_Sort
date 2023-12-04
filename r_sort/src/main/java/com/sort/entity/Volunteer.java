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

    @TableField("Id")
    private int Id;

    @TableField("SubjectName")
    private String Subject;

    @TableField("Region")
    private String Region;

    @TableField("Organize")
    private String Organize;

    @TableField("Url")
    private String Url;

    @TableField("StartTime")
    private Date StartTime;

    @TableField("EndTime")
    private Date EndTime;

}
