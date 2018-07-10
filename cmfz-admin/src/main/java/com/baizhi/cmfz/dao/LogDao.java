package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface LogDao {

    /**
     * 查询日志
     * @return
     */
    public List<Log> selectAll(@Param("start") Integer start,@Param("end") Integer end);

    /**
     * 添加日志
     * @param log
     * @return
     */
    public Integer insertLog(Log log);

    /**
     * 查询日志的总数
     * @return
     */
    public Integer selectLogCount();
}
