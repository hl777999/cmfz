package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public interface LogService {

    /**
     * 添加日志
     * @param log
     * @return
     */
    public Integer insetLogs(Log log);

    /**
     * 查询所有日志信息
     * @return
     */
    public Map<String,Object> selectAllLog(Integer newPage,Integer pageSize);
}
