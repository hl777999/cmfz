package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    public String login(String id, String password, HttpServletRequest request){
        Manager manager = managerService.login(id, password);
        HttpSession session = request.getSession();
        if (manager!=null){
            session.setAttribute("manager",manager);
            return "";
        }
        return "";
    }
}
