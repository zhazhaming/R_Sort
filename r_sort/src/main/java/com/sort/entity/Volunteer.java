package com.sort.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.Subject;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volunteer {

    private int id;

    private String Subject;

    private String Region;

    private String Organize;

    private Date StartTime;

    private Date EndTime;

}
