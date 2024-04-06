package com.sort.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhazhaming
 * @Date: 2024/04/06/22:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleApiRequest {

    private String code;
    private String msg;
    private ArticleApiData<VolunteerApiData> result;
}
