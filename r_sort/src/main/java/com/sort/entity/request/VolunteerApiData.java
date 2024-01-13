package com.sort.entity.request;

import com.sort.entity.vo.VolunteerVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/13/11:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerApiData<T> implements Serializable {

    private List<VolunteerVo> records;
    private int totalPage;
    private int pageSize;
    private int pageIndex;
    private int totalRecord;

}
