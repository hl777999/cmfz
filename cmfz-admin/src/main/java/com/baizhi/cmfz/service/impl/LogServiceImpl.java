package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    @Transactional
    public Integer insetLogs(Log log) {
        return logDao.insertLog(log);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String,Object> selectAllLog(Integer newPage,Integer pageSize) {
        List<Log> logs = logDao.selectAll((newPage-1)*pageSize,pageSize);
        Integer integer = logDao.selectLogCount();
        Map<String,Object> map=new HashMap<>();
        map.put("total",integer);
        map.put("rows",logs);
        return map;
    }
}
