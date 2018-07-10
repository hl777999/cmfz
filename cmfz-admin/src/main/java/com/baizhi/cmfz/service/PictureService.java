package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/5.
 */
@Service
public interface PictureService {
    /**
     * 查询所有的轮播图
     * @param newPage
     * @param pageSize
     * @return
     */
    public Map<String,Object> queryAll(Integer newPage, Integer pageSize);

    /**
     * 添加一个图片
     * @param picture
     * @return
     */
    public  boolean addPic(Picture picture);

    /**
     * 删除图片
     * @param pictureid
     * @return
     */
    public boolean removePic(String pictureid);

    /**
     * 修改图片的轮播状态
     * @param pictureid
     * @param status
     * @return
     */
    public  boolean modifyPic(String pictureid ,String status);
}
