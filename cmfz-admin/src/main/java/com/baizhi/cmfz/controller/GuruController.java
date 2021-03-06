package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
//import org.jeecgframework.poi.excel.ExcelImportUtil;
//import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
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
    public @ResponseBody
    Map<String, Object> queryAllGuru(@RequestParam("page") Integer newPage, @RequestParam("rows") Integer pageSize, String name, String value) {
        if (name != null && name.equals("guruid")) {
            return guruService.queryAllGuru(newPage, pageSize, Integer.valueOf(value), null, null);
        } else if (name != null && name.equals("guruname")) {
            return guruService.queryAllGuru(newPage, pageSize, null, value, null);
        } else if (name != null && name.equals("status")) {
            return guruService.queryAllGuru(newPage, pageSize, null, null, value);
        }
        return guruService.queryAllGuru(newPage, pageSize, null, null, null);
    }

    @RequestMapping("/addguru")
    public @ResponseBody
    boolean addGuru(Guru guru, MultipartFile myfiled, HttpServletRequest request) throws IOException {
        //获得上传图片文件夹
        String realPath = request.getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String path = realPath.substring(0, lastIndexOf);
        int lastIndexOf1 = path.lastIndexOf("\\");
        String path1 = path.substring(0, lastIndexOf1);
        //获取文件名
        String Filename = myfiled.getOriginalFilename();
        //获取文件的后缀名
        String suffix = Filename.substring(Filename.lastIndexOf("."));
        //将文件写入指定的文件夹中
        myfiled.transferTo(new File(path1 + "\\upload" + "/" + Filename));
        guru.setGurupic(Filename);
        return guruService.addGuru(guru);
    }

    @RequestMapping("/modifyguru")
    public @ResponseBody
    boolean modifyGuru(Guru guru) {
        return guruService.modifyGuru(guru);
    }

    @RequestMapping("/removeguru")
    public @ResponseBody
    boolean removeGuru(Integer guruid) {
        return guruService.removeGuru(guruid);
    }

    @RequestMapping("/uploadexcel")
    public @ResponseBody
    boolean importExcel(MultipartFile myfiled, HttpServletRequest request) throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setNeedSave(true);
        String path = request.getSession().getServletContext().getRealPath("");
        File f = new File(path + "/excel" + myfiled.getOriginalFilename());
        List<Guru> gurus = ExcelImportUtil.importExcel(myfiled.getInputStream(), Guru.class, importParams);
        myfiled.transferTo(f);
        for (Guru guru : gurus) {
            guru.setCreatetime(new Date());
        }
        return guruService.addBatchGuru(gurus);
    }
}
