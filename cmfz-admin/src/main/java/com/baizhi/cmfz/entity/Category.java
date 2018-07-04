package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 分类实体类
 * Created by huanglei on 2018/7/3.
 */
public class Category implements Serializable {
    private String category_id;
    private String category_name;
    private String category_type;
    private String user_id;

    public Category() {
    }

    public Category(String category_id, String category_name, String category_type, String user_id) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_type = category_type;
        this.user_id = user_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type = category_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id='" + category_id + '\'' +
                ", category_name='" + category_name + '\'' +
                ", category_type='" + category_type + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
