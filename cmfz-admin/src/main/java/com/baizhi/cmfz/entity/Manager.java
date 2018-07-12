package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description 管理员实体类
 * Created by huanglei on 2018/7/3.
 */
@Component
public class Manager  implements Serializable{
    private Integer mgrid;
    private String mgrname;
    private String mgrpwd;
    private String mgrsalt;
    private String mgrstatus;

    public Manager() {
    }

    public Manager(Integer mgrid, String mgrname, String mgrpwd, String mgrsalt, String mgrstatus) {
        this.mgrid = mgrid;
        this.mgrname = mgrname;
        this.mgrpwd = mgrpwd;
        this.mgrsalt = mgrsalt;
        this.mgrstatus = mgrstatus;
    }

    public Integer getMgrid() {
        return mgrid;
    }

    public void setMgrid(Integer mgrid) {
        this.mgrid = mgrid;
    }

    public String getMgrname() {
        return mgrname;
    }

    public void setMgrname(String mgrname) {
        this.mgrname = mgrname;
    }

    public String getMgrpwd() {
        return mgrpwd;
    }

    public void setMgrpwd(String mgrpwd) {
        this.mgrpwd = mgrpwd;
    }

    public String getMgrsalt() {
        return mgrsalt;
    }

    public void setMgrsalt(String mgrsalt) {
        this.mgrsalt = mgrsalt;
    }

    public String getMgrstatus() {
        return mgrstatus;
    }

    public void setMgrstatus(String mgrstatus) {
        this.mgrstatus = mgrstatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mgrid='" + mgrid + '\'' +
                ", mgrname='" + mgrname + '\'' +
                ", mgrpwd='" + mgrpwd + '\'' +
                ", mgrsalt='" + mgrsalt + '\'' +
                ", mgrstatus='" + mgrstatus + '\'' +
                '}';
    }
}
