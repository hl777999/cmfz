package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/6.
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> queryAllGuru(Integer newPage, Integer pageSize, String guruid, String guruname, String status) {
        Map<String,Object> map=new HashMap<>();
        List<Guru> gurus = guruDao.selectAllGuru((newPage - 1) * pageSize, pageSize, guruid, guruname, status);
        Integer count = guruDao.selectAllCount();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    public boolean insertGuru(Guru guru) {
        return false;
    }

    @Override
    public boolean modifyGuru(Guru guru) {
        return false;
    }

    @Override
    public boolean removeGuru(String id) {
        return false;
    }
}
