package com.sort.controller;


import com.baomidou.mybatisplus.extension.api.R;
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
        List<Article> articleList = articleService.getArticleList (page, pageSize);
        return R.ok (articleList);
    }

    @GetMapping("/articleDetail")
    public R<Article> queryArticleDetil(@RequestParam Integer articleId){

        return R.ok (new Article (  ));
    }
}
