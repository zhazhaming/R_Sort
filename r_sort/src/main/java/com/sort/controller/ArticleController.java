package com.sort.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sort.entity.Article;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "文章查询接口")
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/articleList")
    public R<List<Article>> queryArticleList(@RequestParam Integer page,
                                             @RequestParam Integer pageSize){

    }

    @GetMapping("/articleDetail")
    public R<Article> queryArticleDetil(@RequestParam Integer articleId){

    }
}
