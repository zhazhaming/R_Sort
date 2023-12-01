package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.Article;
import com.sort.entity.GarbageEncyclopedia;
import com.sort.mapper.ArticleMapper;
import com.sort.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService  {
    @Override
    public List<Article> getArticleList(Integer page, Integer pagesize) {
        QueryWrapper<List<Article>> wrapperArticle = new QueryWrapper<>();
        wrapperArticle.select("Id","Title","Introduce","Content","StartTime","EndTime");
        Page<Article> articlePage = new Page<>(page,pagesize);
        baseMapper.selectList(wrapperArticle);
        return null;
    }

    @Override
    public Article getArticleDetil(Integer articleId) {
        return null;
    }
}
