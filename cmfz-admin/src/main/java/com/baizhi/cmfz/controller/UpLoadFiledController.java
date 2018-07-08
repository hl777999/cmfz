package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/6.
 */
@Controller
@RequestMapping("/uploadfiled")
public class UpLoadFiledController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/filed")
    public @ResponseBody boolean upload(MultipartFile myfiled, HttpServletRequest request,String name,String dept) throws IOException {
        String realPath = request.getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String path = realPath.substring(0, lastIndexOf);
        int lastIndexOf1 = path.lastIndexOf("\\");
        //获得上传图片文件夹
        String path1 = path.substring(0, lastIndexOf1);
        //    生成唯一的UUID作为文件编号和文件名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //获取文件的后缀名
        String originalFilename = myfiled.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        myfiled.transferTo(new File(path1+"\\upload"+"/"+originalFilename));
        boolean b = pictureService.addPic(new Picture(uuid, originalFilename, null, name, dept));
        if (b){
            return true;
        }
        return false;
    }
}
