package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/5.
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
   @Autowired
    private PictureService pictureService;

    @RequestMapping("/picall")
    public @ResponseBody  Map<String,Object> queryPic(@RequestParam("page") Integer newPage, @RequestParam("rows") Integer pageSize){
        return pictureService.queryAll(newPage,pageSize);
    }

    @RequestMapping("/deletepic")
    public @ResponseBody boolean deletePic(String id){
        return pictureService.removePic(id);
    }

    @RequestMapping("/modifypic")
    public @ResponseBody boolean modifyPic(String pictureid,String picturestatus){
        return pictureService.modifyPic(pictureid, picturestatus);
    }
}
