package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/4.
 */
@Service
public interface ManagerService {
    /**
     * 管理员登录功能
     * 黄磊
     * @param  id ,password  管理员登入的账号和密码
     * @return  返回管理员的信息
     */
    public Manager queryByIdandPwd(String id ,String password);

    /**
     * 管理员注册功能
     * @param manager 管理员注册所需的信息
     * @return 返回true表示注册成功，否则失败
     */
    public boolean addManger(Manager manager);

    /**
     * 根据ID查找管理员功能
     * @param id 需要查找的管理员ID
     * @return 返回管理员信息，若为NULL则表示没有该管理员信息
     */
    public Manager queryById(String id);
}
