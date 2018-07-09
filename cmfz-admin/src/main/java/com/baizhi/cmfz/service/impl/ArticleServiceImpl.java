package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDao articleDao;

    @Override
    @Transactional
    public boolean addArticle(Article article) {
        article.setDatetime(new Date());
        Integer i = articleDao.insertArticle(article);
        if (i==1){
            return true;
        }
        return false;
    }
}
