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
    public Manager login(String id ,String password);

    /**
     * 管理员注册功能
     * @param manager 管理员注册所需的信息
     * @return 返回true表示注册成功，否则失败
     */
    public boolean regist(Manager manager);
}
