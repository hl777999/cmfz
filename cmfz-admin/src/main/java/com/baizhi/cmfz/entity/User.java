package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 用户实体类
 * Created by huanglei on 2018/7/3.
 */
public class User implements Serializable {
    private String userid;
    private String username;
    private String userbuddhishname;
    private String userpassword;
    private String usersex;
    private String userheadpic;
    private String useraddress;
    private String userphone;
    private String usersigna;
    private String userstatus;
    private String guruid;

    public User() {
    }

    public User(String userid, String username, String userbuddhishname, String userpassword, String usersex, String userheadpic, String useraddress, String userphone, String usersigna, String userstatus, String guruid) {
        this.userid = userid;
        this.username = username;
        this.userbuddhishname = userbuddhishname;
        this.userpassword = userpassword;
        this.usersex = usersex;
        this.userheadpic = userheadpic;
        this.useraddress = useraddress;
        this.userphone = userphone;
        this.usersigna = usersigna;
        this.userstatus = userstatus;
        this.guruid = guruid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserbuddhishname() {
        return userbuddhishname;
    }

    public void setUserbuddhishname(String userbuddhishname) {
        this.userbuddhishname = userbuddhishname;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserheadpic() {
        return userheadpic;
    }

    public void setUserheadpic(String userheadpic) {
        this.userheadpic = userheadpic;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUsersigna() {
        return usersigna;
    }

    public void setUsersigna(String usersigna) {
        this.usersigna = usersigna;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public String getGuruid() {
        return guruid;
    }

    public void setGuruid(String guruid) {
        this.guruid = guruid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userbuddhishname='" + userbuddhishname + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userheadpic='" + userheadpic + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", userphone='" + userphone + '\'' +
                ", usersigna='" + usersigna + '\'' +
                ", userstatus='" + userstatus + '\'' +
                ", guruid='" + guruid + '\'' +
                '}';
    }
}
