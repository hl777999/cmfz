package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/8.
 */
@Service
public interface ArticleService {
    public boolean addArticle(Article article);
}
