package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface PictureDao {
    /**
     * 分页查询轮播图片
     * @param start
     * @param end
     * @return
     */
    public List<Picture> selectAll(@Param("start") Integer start,@Param("end") Integer end);

    /**
     * 查询图片的总数
     * @return
     */
    public Integer selectTotal();

    /**
     * 添加图片
     */
    public Integer insertPic(Picture picture);

    /**
     * 删除图片
     * @param pictureid
     * @return
     */
    public Integer deletePic(@Param("id") String pictureid);

    /**
     * 修改图片的轮播状态
     * @param pictureid
     * @param picturestatus
     * @return
     */
    public Integer updatePic(@Param("id") String pictureid,@Param("status") String picturestatus);
}
