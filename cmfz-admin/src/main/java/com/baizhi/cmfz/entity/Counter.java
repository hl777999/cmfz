package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 计数器实体类
 * Created by huanglei on 2018/7/3.
 */
public class Counter implements Serializable {
    private String counter_id;
    private String counter_name;
    private String user_id;
    private String category_id;

    public Counter() {
    }

    public Counter(String counter_id, String counter_name, String user_id, String category_id) {
        this.counter_id = counter_id;
        this.counter_name = counter_name;
        this.user_id = user_id;
        this.category_id = category_id;
    }

    public String getCounter_id() {
        return counter_id;
    }

    public void setCounter_id(String counter_id) {
        this.counter_id = counter_id;
    }

    public String getCounter_name() {
        return counter_name;
    }

    public void setCounter_name(String counter_name) {
        this.counter_name = counter_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "counter_id='" + counter_id + '\'' +
                ", counter_name='" + counter_name + '\'' +
                ", user_id='" + user_id + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }
}
