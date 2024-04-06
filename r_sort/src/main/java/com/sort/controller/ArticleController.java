package com.sort.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.constant.ArticleConstant;
import com.sort.entity.Article;
import com.sort.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@Api(description = "文章查询接口")
@CrossOrigin
@RequestMapping("api/v1/article")
public class ArticleController {

    @Autowired
    ArticleService  articleService;

    @GetMapping("/articleList")
    public R<List<Article>> queryArticleList(@RequestParam Integer page,
                                             @RequestParam Integer pageSize){
        //传参设置判断
        if (page==null || pageSize==null){
            R.failed(ResponMsg.ARTICLE_PAGESIZE_ERROR.msg()).setCode (ResponMsg.ARTICLE_PAGESIZE_ERROR.status ());
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
        return R.ok (articleList).setCode (ResponMsg.Success.status ( ));
    }

    @GetMapping("/articleDetail")
    public R<Article> queryArticleDetil(@RequestParam String articleId){
        if (StringUtils.isBlank (articleId)){
            R.failed(ResponMsg.ARTICLE_ID_ERROR.msg()).setCode (ResponMsg.ARTICLE_ID_ERROR.status ());
        }
        Article articleDetil = articleService.getArticleDetil(articleId);
        return R.ok (articleDetil).setCode (ResponMsg.Success.status ( ));
    }

    @PostMapping("/addArticle")
    public R<Integer> addArticle(Integer pageNumber){
        if (pageNumber<=0){
            pageNumber = ArticleConstant.article_request_number;
        }
        int number = articleService.reqArticle (pageNumber);
        if (number<=0) return R.failed (ResponMsg.Error.msg ());
        return R.ok (number).setCode (ResponMsg.Success.status ( ));
    }


}
