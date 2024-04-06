package com.sort.entity.request;

import com.sort.entity.Article;
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
public class ArticleApiData<T> implements Serializable {

    private int curpage;
    private int allnum;
    private List<Article> newslist;

}
