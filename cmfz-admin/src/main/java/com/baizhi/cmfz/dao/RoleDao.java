package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */
public interface RoleDao {
    /**
     * 查询管理员的权限信息
     * @param id
     * @return
     */
    public List<Role> selectByIdtoRole(@Param("id") Integer id);

    /**
     * 查询管理员可操作的权限信息
     * @param id
     * @return
     */
    public List<Permission> selectByIdtoPermission(@Param("id") Integer id);
}
