package com.baizhi.cmfz.entity;

/**
 * Created by Administrator on 2018/7/12.
 */
public class Role {
    private Integer roleid;
    private String rolename;
    private String roletag;

    public Role() {
    }

    public Role(Integer roleid, String rolename, String roletag) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roletag = roletag;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoletag() {
        return roletag;
    }

    public void setRoletag(String roletag) {
        this.roletag = roletag;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", roletag='" + roletag + '\'' +
                '}';
    }
}
