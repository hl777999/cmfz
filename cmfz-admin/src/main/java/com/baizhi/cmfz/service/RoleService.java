package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */
@Service
public interface RoleService {

    public List<Role> queryByIdtoRole(Integer id);

    public List<Permission> queryByIdtoPermission(Integer id);
}
