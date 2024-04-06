package com.sort.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.Article;
import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.List;

public interface ArticleService extends IService<Article> {

    public List<Article> getArticleList(Integer page,Integer pagesize);

    public Article getArticleDetil(String articleId);

    public Integer getArticleCounts();

    public Integer reqArticle(int pageNumber);

}
