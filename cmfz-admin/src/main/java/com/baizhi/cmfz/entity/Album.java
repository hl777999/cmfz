package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 专辑实体类
 * Created by huanglei on 2018/7/3.
 */
public class Album implements Serializable {
    private String albumid;
    private String albumname;
    private String albumauthor;
    private String albumcv;
    private Integer albumcount;
    private Integer albumscore;
    private String albumsrc;
    private Date publishtime;
    private String albumcontent;

    public Album() {
    }

    public Album(String albumid, String albumname, String albumauthor, String albumcv, Integer albumcount, Integer albumscore, String albumsrc, Date publishtime, String albumcontent) {
        this.albumid = albumid;
        this.albumname = albumname;
        this.albumauthor = albumauthor;
        this.albumcv = albumcv;
        this.albumcount = albumcount;
        this.albumscore = albumscore;
        this.albumsrc = albumsrc;
        this.publishtime = publishtime;
        this.albumcontent = albumcontent;
    }

    public String getAlbumid() {
        return albumid;
    }

    public void setAlbumid(String albumid) {
        this.albumid = albumid;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getAlbumauthor() {
        return albumauthor;
    }

    public void setAlbumauthor(String albumauthor) {
        this.albumauthor = albumauthor;
    }

    public String getAlbumcv() {
        return albumcv;
    }

    public void setAlbumcv(String albumcv) {
        this.albumcv = albumcv;
    }

    public Integer getAlbumcount() {
        return albumcount;
    }

    public void setAlbumcount(Integer albumcount) {
        this.albumcount = albumcount;
    }

    public Integer getAlbumscore() {
        return albumscore;
    }

    public void setAlbumscore(Integer albumscore) {
        this.albumscore = albumscore;
    }

    public String getAlbumsrc() {
        return albumsrc;
    }

    public void setAlbumsrc(String albumsrc) {
        this.albumsrc = albumsrc;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getAlbumcontent() {
        return albumcontent;
    }

    public void setAlbumcontent(String albumcontent) {
        this.albumcontent = albumcontent;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumid='" + albumid + '\'' +
                ", albumname='" + albumname + '\'' +
                ", albumauthor='" + albumauthor + '\'' +
                ", albumcv='" + albumcv + '\'' +
                ", albumcount=" + albumcount +
                ", albumscore=" + albumscore +
                ", albumsrc='" + albumsrc + '\'' +
                ", publishtime=" + publishtime +
                ", albumcontent='" + albumcontent + '\'' +
                '}';
    }
}
