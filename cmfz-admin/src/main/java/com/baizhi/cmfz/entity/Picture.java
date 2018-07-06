package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 图片实体类
 * Created by huanglei on 2018/7/3.
 */
public class Picture implements Serializable {
    private String pictureid;
    private String picturepath;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date picturedate;
    private String picturedescription;
    private String picturestatus;

    public Picture() {
    }

    public Picture(String pictureid, String picturepath, Date picturedate, String picturedescription, String picturestatus) {
        this.pictureid = pictureid;
        this.picturepath = picturepath;
        this.picturedate = picturedate;
        this.picturedescription = picturedescription;
        this.picturestatus = picturestatus;
    }

    public String getPictureid() {
        return pictureid;
    }

    public void setPictureid(String pictureid) {
        this.pictureid = pictureid;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public Date getPicturedate() {
        return picturedate;
    }

    public void setPicturedate(Date picturedate) {
        this.picturedate = picturedate;
    }

    public String getPicturedescription() {
        return picturedescription;
    }

    public void setPicturedescription(String picturedescription) {
        this.picturedescription = picturedescription;
    }

    public String getPicturestatus() {
        return picturestatus;
    }

    public void setPicturestatus(String picturestatus) {
        this.picturestatus = picturestatus;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureid='" + pictureid + '\'' +
                ", picturepath='" + picturepath + '\'' +
                ", picturedate=" + picturedate +
                ", picturedescription='" + picturedescription + '\'' +
                ", picturestatus='" + picturestatus + '\'' +
                '}';
    }
}
