package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/9.
 */
public class Log {
    private Integer id;
    private String user;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String resource;
    private String action;
    private String message;
    private String result;

    public Log() {
    }

    public Log(Integer id, String user, Date time, String resource, String action, String message, String result) {
        this.id = id;
        this.user = user;
        this.time = time;
        this.resource = resource;
        this.action = action;
        this.message = message;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
