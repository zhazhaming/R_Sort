package com.sort.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/13/11:42
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerApiRequest<T> implements Serializable {

    private String code;
    private String msg;
    private VolunteerApiData<VolunteerApiData> data;

}
