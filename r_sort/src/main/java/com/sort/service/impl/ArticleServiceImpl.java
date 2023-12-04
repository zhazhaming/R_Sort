package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.Article;

import com.sort.mapper.ArticleMapper;
import com.sort.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService  {
    @Override
    public List<Article> getArticleList(Integer page, Integer pagesize) {
        Page<Article> articlePage = new Page<> (page,pagesize);
        QueryWrapper<Article> wrapperArticle = new QueryWrapper<>();
        wrapperArticle.select("Id","Title","Introduce","Content","StartTime","EndTime").orderByDesc("StartTime");
        baseMapper.selectPage(articlePage, wrapperArticle);
        List<Article> articleList = articlePage.getRecords();
        return articleList;
    }

    @Override
    public Article getArticleDetil(Integer articleId) {
        QueryWrapper<Article> wrapperArticle = new QueryWrapper<>();
        wrapperArticle.eq("id",articleId);
        Article article = baseMapper.selectById(articleId);
        return article;
    }

    @Override
    public Integer getArticleCounts() {
        QueryWrapper<Article> wrapperArticle = new QueryWrapper<>();
        Integer articleCount = baseMapper.selectCount(wrapperArticle);
        return articleCount;
    }
}
