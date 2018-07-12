package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员功能接口
 * Created by huanlei on 2018/7/4.
 */
public interface ManagerDao {
    /**
     * @Description 根据ID查询一个管理员的信息
     * @Author      黄磊
     * @Time        2018-07-04 13:24:30
     * @Param       用于查询的ID
     * @Exception   无
     */
    public Manager selectById(@Param("id") Integer id);
    /**
     * @Description 添加一个管理员信息
     * @Author      黄磊
     * @Time        2018-07-04 13:24:30
     * @Param       要添加的管理员信息
     * @Exception   无
     */
    public Integer insertManager(Manager manager);
}
