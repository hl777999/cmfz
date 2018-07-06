package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/6.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    @RequestMapping("/queryall")
    public @ResponseBody Map<String,Object> queryAllGuru(@RequestParam("page") Integer newPage,@RequestParam("rows") Integer pageSize, String name, String value){
        if (name!=null && name.equals("guruid")){
              return guruService.queryAllGuru(newPage,pageSize,value,null,null);
        }else if(name !=null && name.equals("guruname")){
              return guruService.queryAllGuru(newPage,pageSize,null,value,null);
        }else if(name !=null && name.equals("status")){
              return  guruService.queryAllGuru(newPage,pageSize,null,null,value);
        }
        return guruService.queryAllGuru(newPage,pageSize,null,null,null);
    }
}
