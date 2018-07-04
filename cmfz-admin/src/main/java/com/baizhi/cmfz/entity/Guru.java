package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 上师实体类
 * Created by huanglei on 2018/7/3.
 */
public class Guru implements Serializable {
    private String guru_id;
    private String guru_name;
    private String guru_pic;
    private String guru_summary;

    public Guru() {
    }

    public Guru(String guru_id, String guru_name, String guru_pic, String guru_summary) {
        this.guru_id = guru_id;
        this.guru_name = guru_name;
        this.guru_pic = guru_pic;
        this.guru_summary = guru_summary;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    public String getGuru_name() {
        return guru_name;
    }

    public void setGuru_name(String guru_name) {
        this.guru_name = guru_name;
    }

    public String getGuru_pic() {
        return guru_pic;
    }

    public void setGuru_pic(String guru_pic) {
        this.guru_pic = guru_pic;
    }

    public String getGuru_summary() {
        return guru_summary;
    }

    public void setGuru_summary(String guru_summary) {
        this.guru_summary = guru_summary;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guru_id='" + guru_id + '\'' +
                ", guru_name='" + guru_name + '\'' +
                ", guru_pic='" + guru_pic + '\'' +
                ", guru_summary='" + guru_summary + '\'' +
                '}';
    }
}
