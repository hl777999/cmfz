package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.CreateValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    /**
     *管理员登录功能
     */
//    @RequestMapping("/login")
//    public String login(Integer id, String password, HttpServletRequest request){
//        Manager manager = managerService.queryByIdandPwd(id, password);
//        HttpSession session = request.getSession();
//        if (manager!=null){
//            session.setAttribute("manager",manager);
//            return "WEB-INF/main/main";
//        }
//        return "redirect:/login.jsp";
//    }
    @RequestMapping("/login")
    public String login(Integer id,String password,HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(id.toString(),password));
            System.out.println(subject.hasRole("root") ? "有root角色":"无root角色");
            Manager manager = managerService.queryById(id);
            HttpSession session = request.getSession();
            session.setAttribute("manager",manager);
            return "WEB-INF/main/main";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "redirect:/login.jsp";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return "redirect:/login.jsp";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "redirect:/login.jsp";
        }

    }

    /**
     * 验证管理员身份是否存在功能
     * @param id
     * @return
     */
    @RequestMapping("/validatemgrid")
    public @ResponseBody boolean validatemgrid(Integer id){
        Manager manager = managerService.queryById(id);
        if (manager!=null){
            return true;
        }
        return false;
    }

    /**
     * 生成验证码功能
     */
    @RequestMapping("/validatecode")
    public @ResponseBody void createvalidatecode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CreateValidateCode vCode = new CreateValidateCode(75, 28, 4, 10);
        HttpSession session = request.getSession();
        session.setAttribute("code",vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    /**
     * 验证输入的验证码是否正确
     */
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

    @RequestMapping("/logout")
    public  String logout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/login.jsp";
    }
}
