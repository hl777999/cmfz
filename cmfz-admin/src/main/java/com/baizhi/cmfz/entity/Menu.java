package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体类
 * Created by Administrator on 2018/7/5.
 */
public class Menu implements Serializable {
    private String menuid;
    private String menuname;
    private String menucode;
    private String menuicon;
    private String menuurl;
    private String menulevel;
    private String menuparentid;
    private List<Menu> menus;
    public Menu() {
    }

    public Menu(String menuid, String menuname, String menucode, String menuicon, String menuurl, String menulevel, String menuparentid, List<Menu> menus) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.menucode = menucode;
        this.menuicon = menuicon;
        this.menuurl = menuurl;
        this.menulevel = menulevel;
        this.menuparentid = menuparentid;
        this.menus = menus;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    public String getMenulevel() {
        return menulevel;
    }

    public void setMenulevel(String menulevel) {
        this.menulevel = menulevel;
    }

    public String getMenuparentid() {
        return menuparentid;
    }

    public void setMenuparentid(String menuparentid) {
        this.menuparentid = menuparentid;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuid='" + menuid + '\'' +
                ", menuname='" + menuname + '\'' +
                ", menucode='" + menucode + '\'' +
                ", menuicon='" + menuicon + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", menulevel='" + menulevel + '\'' +
                ", menuparentid='" + menuparentid + '\'' +
                ", menus=" + menus +
                '}';
    }
}
