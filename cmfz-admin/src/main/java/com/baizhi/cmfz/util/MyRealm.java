package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/11.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoleService roleService;
    /**
     * 获取授权信息的方法（AuthorizingRealm的抽象方法）
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Integer username = (Integer) principalCollection.getPrimaryPrincipal();
        List<Permission> permissions = roleService.queryByIdtoPermission(username);
        List<Role> roles = roleService.queryByIdtoRole(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            info.addRole(role.getRoletag());
        }
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissiontag());
        }
        return info;
    }

    /**
     * 获取认证信息的方法(AuthenticatingRealm的抽象方法)
     *
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken user = (UsernamePasswordToken) token;
        String username = user.getUsername();
        Manager manager = managerService.queryById(Integer.valueOf(username));
        if (manager!=null) {
            System.out.println("------------------------");
            return new SimpleAuthenticationInfo(manager.getMgrid(),
                    manager.getMgrpwd(),
                    ByteSource.Util.bytes(manager.getMgrsalt()),
                    UUID.randomUUID().toString());
        }
        return null;
    }
}
