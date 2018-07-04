package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 文章实体类
 * Created by huanglei on 2018/7/3.
 */
public class Article implements Serializable {
    private String articleid;
    private String articlename;
    private String guruid;
    private String articleintroduction;
    private Date datetime;
    private String articlepic;

    public Article() {
    }

    public Article(String articleid, String articlename, String guruid, String articleintroduction, Date datetime, String articlepic) {
        this.articleid = articleid;
        this.articlename = articlename;
        this.guruid = guruid;
        this.articleintroduction = articleintroduction;
        this.datetime = datetime;
        this.articlepic = articlepic;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public String getGuruid() {
        return guruid;
    }

    public void setGuruid(String guruid) {
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

    public String getArticlepic() {
        return articlepic;
    }

    public void setArticlepic(String articlepic) {
        this.articlepic = articlepic;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleid='" + articleid + '\'' +
                ", articlename='" + articlename + '\'' +
                ", guruid='" + guruid + '\'' +
                ", articleintroduction='" + articleintroduction + '\'' +
                ", datetime=" + datetime +
                ", articlepic='" + articlepic + '\'' +
                '}';
    }
}
