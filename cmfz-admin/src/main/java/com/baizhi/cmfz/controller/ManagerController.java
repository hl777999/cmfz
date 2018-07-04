package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String login(String id, String password, HttpServletRequest request){
        System.out.println(id+"\t"+password);
        Manager manager = managerService.login(id, password);
        HttpSession session = request.getSession();
        if (manager!=null){
            session.setAttribute("manager",manager);
            return "WEB-INF/main/main";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/validatemgrid")
    public @ResponseBody boolean validatemgrid(String id){
        Manager manager = managerService.queryById(id);
        if (manager!=null){
            return true;
        }
        return false;
    }

    @RequestMapping("/validatecode")
    public @ResponseBody void createvalidatecode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CreateValidateCode vCode = new CreateValidateCode(75, 28, 4, 10);
        HttpSession session = request.getSession();
        session.setAttribute("code",vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    @RequestMapping("/checkvalidatecode")
    public @ResponseBody boolean checkValidateCoded(HttpServletRequest request,String ecode){
        HttpSession session = request.getSession();
        String vcode= (String) session.getAttribute("code");
        if (ecode.equals(vcode)){
            session.removeAttribute("code");
            return true;
        }
        return false;
    }
}
