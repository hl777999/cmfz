package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.RoleDao;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> queryByIdtoRole(Integer id) {
        List<Role> roles = roleDao.selectByIdtoRole(id);
        if (roles.isEmpty()){
            return null;
        }
        return roles;
    }

    @Override
    public List<Permission> queryByIdtoPermission(Integer id) {
        List<Permission> permissions = roleDao.selectByIdtoPermission(id);
        if (permissions.isEmpty()){
            return null;
        }
        return permissions;
    }
}
