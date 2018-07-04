package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 图片实体类
 * Created by huanglei on 2018/7/3.
 */
public class Picture implements Serializable {
    private String picture_id;
    private String picture_path;
    private Date picture_date;
    private String picture_description;
    private String picture_status;

    public Picture() {
    }

    public Picture(String picture_id, String picture_path, Date picture_date, String picture_description, String picture_status) {
        this.picture_id = picture_id;
        this.picture_path = picture_path;
        this.picture_date = picture_date;
        this.picture_description = picture_description;
        this.picture_status = picture_status;
    }

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public Date getPicture_date() {
        return picture_date;
    }

    public void setPicture_date(Date picture_date) {
        this.picture_date = picture_date;
    }

    public String getPicture_description() {
        return picture_description;
    }

    public void setPicture_description(String picture_description) {
        this.picture_description = picture_description;
    }

    public String getPicture_status() {
        return picture_status;
    }

    public void setPicture_status(String picture_status) {
        this.picture_status = picture_status;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picture_id='" + picture_id + '\'' +
                ", picture_path='" + picture_path + '\'' +
                ", picture_date=" + picture_date +
                ", picture_description='" + picture_description + '\'' +
                ", picture_status='" + picture_status + '\'' +
                '}';
    }
}
