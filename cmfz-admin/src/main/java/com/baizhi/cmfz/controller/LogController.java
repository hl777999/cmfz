package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/10.
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
   private LogService logService;

    @RequestMapping("/alllog")
    public @ResponseBody  Map<String,Object> queryAllLog(@RequestParam("page") Integer newPage,@RequestParam("rows") Integer pageSize){
        return logService.selectAllLog(newPage, pageSize);
    }

}
