package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/7/8.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private GuruService guruService;

    @RequestMapping("/addarticle")
    public @ResponseBody boolean addArticle(Article article){
        return articleService.addArticle(article);
    }

    @RequestMapping("/guruall")
    public @ResponseBody  List<Guru> searchGuruAll(){
        return guruService.queryAll();
    }
}
