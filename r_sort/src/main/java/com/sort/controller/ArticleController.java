package com.sort.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sort.config.ResponMsg;
import com.sort.entity.Article;
import com.sort.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "文章查询接口")
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService  articleService;

    @GetMapping("/articleList")
    public R<List<Article>> queryArticleList(@RequestParam Integer page,
                                             @RequestParam Integer pageSize){
        //传参设置判断
        if (page==null || pageSize==null){
            R.failed(ResponMsg.ARTICLE_PAGESIZE_ERROR.msg());
        }
        //传参小于0判断
        if (page<=0 ||pageSize <= 0){
            if (page<=0) page = 1;
            if (pageSize<=0) pageSize=1;
        }
        Integer count = articleService.getArticleCounts();
        if (pageSize>count) pageSize = count;
        Integer pageLimit = count/pageSize;
        //传参页数大于所有数据判断
        if (page>pageLimit){
            page = pageLimit;
        }
        List<Article> articleList = articleService.getArticleList (page, pageSize);
        return R.ok (articleList);
    }

    @GetMapping("/articleDetail")
    public R<Article> queryArticleDetil(@RequestParam Integer articleId){
        if (articleId==null){
            R.failed(ResponMsg.ARTICLE_ID_ERROR.msg());
        }
        Article articleDetil = articleService.getArticleDetil(articleId);
        return R.ok (articleDetil);
    }


}
