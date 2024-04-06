package com.sort.Task;

import com.sort.constant.ArticleConstant;
import com.sort.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: zhazhaming
 * @Date: 2024/04/06/23:22
 */
@Slf4j
@Component
public class ArticleTask {
    @Autowired
    ArticleService articleService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void getArticleTask(){
        log.info ("执行定时任务,每天零点重置用户签到");
        articleService.reqArticle (ArticleConstant.article_request_number);
    }
}
