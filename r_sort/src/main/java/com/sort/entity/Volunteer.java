package com.sort.entity;

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
public class Volunteer implements Serializable {

    private int id;

    private String Subject;

    private String Region;

    private String Organize;

    private Date StartTime;

    private Date EndTime;

}
