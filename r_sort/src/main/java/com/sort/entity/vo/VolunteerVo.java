package com.sort.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/11/21:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class VolunteerVo implements Serializable {

    @JsonProperty("missionId")
    private int missionId;

    @JsonProperty("districtName")
    private String districtName;

    @JsonProperty("subject")
    private String subject;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @JsonProperty("startDate")
    private LocalDateTime  startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @JsonProperty("endDate")
    private LocalDateTime endDate;

    @JsonProperty("missionTypeName")
    private String missionTypeName;

    @JsonProperty("missionRegionName")
    private String missionRegionName;

}
