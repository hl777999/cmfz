package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Address;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserService userService;

    @RequestMapping("/querall")
    public @ResponseBody  List<Address> query(String sex){
       if (sex.equals("男")){
           return userService.queryMan();
       }
       return userService.queryWomen();
   }
}
