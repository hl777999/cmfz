package com.baizhi.cmfz.entity;

/**
 * Created by Administrator on 2018/7/12.
 */
public class Permission {
    private Integer resourceid;
    private  String resourcename;
    private String resourcetag;
    private String resourceurl;
    private String permissiontag;

    public Permission() {
    }

    public Permission(Integer resourceid, String resourcename, String resourcetag, String resourceurl, String permissiontag) {
        this.resourceid = resourceid;
        this.resourcename = resourcename;
        this.resourcetag = resourcetag;
        this.resourceurl = resourceurl;
        this.permissiontag = permissiontag;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getResourcetag() {
        return resourcetag;
    }

    public void setResourcetag(String resourcetag) {
        this.resourcetag = resourcetag;
    }

    public String getResourceurl() {
        return resourceurl;
    }

    public void setResourceurl(String resourceurl) {
        this.resourceurl = resourceurl;
    }

    public String getPermissiontag() {
        return permissiontag;
    }

    public void setPermissiontag(String permissiontag) {
        this.permissiontag = permissiontag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "resourceid=" + resourceid +
                ", resourcename='" + resourcename + '\'' +
                ", resourcetag='" + resourcetag + '\'' +
                ", resourceurl='" + resourceurl + '\'' +
                ", permissiontag='" + permissiontag + '\'' +
                '}';
    }
}
