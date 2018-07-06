package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 上师实体类
 * Created by huanglei on 2018/7/3.
 */
public class Guru implements Serializable {
    private String guruid;
    private String guruname;
    private String gurupic;
    private String gurusummary;
    private String gurustatus;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    public Guru() {
    }

    public Guru(String guruid, String guruname, String gurupic, String gurusummary, String gurustatus, Date createtime) {
        this.guruid = guruid;
        this.guruname = guruname;
        this.gurupic = gurupic;
        this.gurusummary = gurusummary;
        this.gurustatus = gurustatus;
        this.createtime = createtime;
    }

    public String getGuruid() {
        return guruid;
    }

    public void setGuruid(String guruid) {
        this.guruid = guruid;
    }

    public String getGuruname() {
        return guruname;
    }

    public void setGuruname(String guruname) {
        this.guruname = guruname;
    }

    public String getGurupic() {
        return gurupic;
    }

    public void setGurupic(String gurupic) {
        this.gurupic = gurupic;
    }

    public String getGurusummary() {
        return gurusummary;
    }

    public void setGurusummary(String gurusummary) {
        this.gurusummary = gurusummary;
    }

    public String getGurustatus() {
        return gurustatus;
    }

    public void setGurustatus(String gurustatus) {
        this.gurustatus = gurustatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruid='" + guruid + '\'' +
                ", guruname='" + guruname + '\'' +
                ", gurupic='" + gurupic + '\'' +
                ", gurusummary='" + gurusummary + '\'' +
                ", gurustatus='" + gurustatus + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
