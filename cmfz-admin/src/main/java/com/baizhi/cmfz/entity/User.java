package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 用户实体类
 * Created by huanglei on 2018/7/3.
 */
public class User implements Serializable {
    private String user_id;
    private String user_name;
    private String user_buddhishname;
    private String user_password;
    private String user_sex;
    private String user_headpic;
    private String user_address;
    private String user_phone;
    private String user_signa;
    private String user_status;
    private String guru_id;

    public User() {
    }

    public User(String user_id, String user_name, String user_buddhishname, String user_password, String user_sex, String user_headpic, String user_address, String user_phone, String user_signa, String user_status, String guru_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_buddhishname = user_buddhishname;
        this.user_password = user_password;
        this.user_sex = user_sex;
        this.user_headpic = user_headpic;
        this.user_address = user_address;
        this.user_phone = user_phone;
        this.user_signa = user_signa;
        this.user_status = user_status;
        this.guru_id = guru_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_buddhishname() {
        return user_buddhishname;
    }

    public void setUser_buddhishname(String user_buddhishname) {
        this.user_buddhishname = user_buddhishname;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_headpic() {
        return user_headpic;
    }

    public void setUser_headpic(String user_headpic) {
        this.user_headpic = user_headpic;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_signa() {
        return user_signa;
    }

    public void setUser_signa(String user_signa) {
        this.user_signa = user_signa;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_buddhishname='" + user_buddhishname + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_headpic='" + user_headpic + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_signa='" + user_signa + '\'' +
                ", user_status='" + user_status + '\'' +
                ", guru_id='" + guru_id + '\'' +
                '}';
    }
}
