package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
public interface GuruDao {

    /**
     * 查询所有的上师信息
     * @return
     */
    public List<Guru> selectAllGuru(@Param("start") Integer start,@Param("end") Integer end,@Param("id") String guruid,@Param("name") String guruname,@Param("status") String status);

    /**
     * 添加上师信息
     * @param guru
     * @return
     */
    public Integer insertGuru(Guru guru);

    /**
     * 删除上师
     * @param id
     * @return
     */
    public Integer deleteGuru(@Param("id") String id);

    /**
     * 修改上师信息
     * @param guru
     * @return
     */
    public Integer updateGuru(Guru guru);

    /**
     * 查询上师信息的总数
     * @return
     */
    public Integer selectAllCount();
}
