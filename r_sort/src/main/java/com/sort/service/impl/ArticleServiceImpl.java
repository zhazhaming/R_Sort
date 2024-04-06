package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.Article;

import com.sort.entity.request.ArticleApiRequest;
import com.sort.mapper.ArticleMapper;
import com.sort.service.ArticleService;
import com.sort.util.RestTemplateUtil;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService  {

    @Value ("${tianapi.apikey}")
    private String apikey;

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Override
    public List<Article> getArticleList(Integer page, Integer pagesize) {
        Page<Article> articlePage = new Page<> (page,pagesize);
        QueryWrapper<Article> wrapperArticle = new QueryWrapper<>();
        wrapperArticle.select();
        baseMapper.selectPage(articlePage, wrapperArticle);
        List<Article> articleList = articlePage.getRecords();
        return articleList;
    }

    @Override
    public Article getArticleDetil(String articleId) {
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

    @Override
    public Integer reqArticle(int pageNumber) {
        String apiUrl =  "https://apis.tianapi.com/lajifenleinews/index?rand=0&key="+apikey+"&num="+pageNumber;

        List<Article> newslist = restTemplateUtil.get (apiUrl, ArticleApiRequest.class).getResult ( ).getNewslist ( );
        List<Article> articleList = this.list (new LambdaQueryWrapper<Article> (  ).select (Article::getId));

        List<Article> articleListInsert =
                newslist.stream ().filter (article -> !articleList.contains (article.getId ()))
                        .filter (article -> StringUtils.isNotBlank (article.getTitle ()))
                        .filter (article -> StringUtils.isNotBlank (article.getDescription ()))
                        .filter (article -> StringUtils.isNotBlank (article.getUrl ()))
                        .filter (article -> checkUrl (article.getUrl ()))
                        .collect (Collectors.toList ());

        boolean saveBatch = this.saveBatch (articleListInsert);
        if (saveBatch) return articleListInsert.size ();
        return 0;
    }

    public boolean checkUrl(String url){
        //url不可访问，则返回false
        if (url.contains("sina")) {
            return false;
        }
        return true;
    }
}
