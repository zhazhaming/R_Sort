package com.sort.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private int id;

    private String Title;

    private String Introduce;

    private String Content;

    private Date StartTime;

    private Date EndTime;
}
