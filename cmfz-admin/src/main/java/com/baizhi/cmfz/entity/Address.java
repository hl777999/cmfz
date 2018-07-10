package com.baizhi.cmfz.entity;

/**
 * Created by Administrator on 2018/7/9.
 */
public class Address {
    private String name;
    private Integer value;
    public Address(String name) {
        this.name = name;
    }

    public Address() {
    }

    public Address(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
