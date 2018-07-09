package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 文章实体类
 * Created by huanglei on 2018/7/3.
 */
public class Article implements Serializable {
    private Integer articleid;
    private String articlename;
    private Integer guruid;
    private String articleintroduction;
    private Date datetime;
    private String articlestatus;

    public Article() {
    }

    public Article(Integer articleid, String articlename, Integer guruid, String articleintroduction, Date datetime, String articlestatus) {
        this.articleid = articleid;
        this.articlename = articlename;
        this.guruid = guruid;
        this.articleintroduction = articleintroduction;
        this.datetime = datetime;
        this.articlestatus = articlestatus;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public Integer getGuruid() {
        return guruid;
    }

    public void setGuruid(Integer guruid) {
        this.guruid = guruid;
    }

    public String getArticleintroduction() {
        return articleintroduction;
    }

    public void setArticleintroduction(String articleintroduction) {
        this.articleintroduction = articleintroduction;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getArticlestatus() {
        return articlestatus;
    }

    public void setArticlestatus(String articlestatus) {
        this.articlestatus = articlestatus;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleid=" + articleid +
                ", articlename='" + articlename + '\'' +
                ", guruid='" + guruid + '\'' +
                ", articleintroduction='" + articleintroduction + '\'' +
                ", datetime=" + datetime +
                ", articlestatus='" + articlestatus + '\'' +
                '}';
    }
}
