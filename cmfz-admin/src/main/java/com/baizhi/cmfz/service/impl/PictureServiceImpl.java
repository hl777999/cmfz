package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/5.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;
    @Override
    @Transactional(readOnly = true)
    public Map<String,Object> queryAll(Integer newPage, Integer pageSize) {
        List<Picture> pictures = pictureDao.selectAll((newPage - 1) * pageSize, pageSize);
        Integer integer = pictureDao.selectTotal();
        Map<String,Object> map =new HashMap<>();
        map.put("total", integer);
        map.put("rows", pictures);
        return map;
    }

    @Override
    @Transactional
    public boolean addPic(Picture picture) {
        picture.setPicturedate(new Date());
        Integer integer = pictureDao.insertPic(picture);
        if (integer==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean removePic(String pictureid) {
        Integer i = pictureDao.deletePic(pictureid);
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean modifyPic(String pictureid, String status) {
        Integer i = pictureDao.updatePic(pictureid, status);
        if (i==1){
            return true;
        }
        return false;
    }
}
