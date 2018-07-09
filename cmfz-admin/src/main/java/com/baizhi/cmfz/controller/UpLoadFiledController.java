package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.service.PictureService;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/6.
 */
@Controller
@RequestMapping("/uploadfiled")
public class UpLoadFiledController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private GuruService guruService;

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

    @RequestMapping("/downloadguru")
    public void export(HttpServletResponse response) throws IOException {
        List<Guru> gurus = guruService.queryAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("上师", "上师信息表"), Guru.class, gurus);
        ServletOutputStream out = response.getOutputStream();
        // 文件下载 设置响应头
        // 注意：响应头 默认使用的编码格式iso-8859-1
        String fileName = new String("上师信息.xls".getBytes(), "iso-8859-1");
        response.setContentType("application/vnd.ms-excel"); //响应类型  text/html  application/json
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        // 导出 文件下载的方式
        workbook.write(out);
        out.close();
    }

    /**
     * 多文件上传
     * @param files
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));
                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }
}
