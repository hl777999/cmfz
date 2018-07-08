package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public Map<String, Object> queryAllGuru(Integer newPage, Integer pageSize, Integer guruid, String guruname, String status) {
        Map<String,Object> map=new HashMap<>();
        List<Guru> gurus = guruDao.selectAllGuru((newPage - 1) * pageSize, pageSize, guruid, guruname, status);
        Integer count = guruDao.selectAllCount();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    @Transactional
    public boolean insertGuru(Guru guru) {
        guru.setCreatetime(new Date());
        Integer i = guruDao.insertGuru(guru);
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean modifyGuru(Guru guru) {
        guru.setCreatetime(new Date());
        Integer i = guruDao.updateGuru(guru);
        if (i==1) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean removeGuru(Integer id) {
        Integer i = guruDao.deleteGuru(id);
        if (i==1) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean batchAddGuru(List<Guru> gurus) {
        Integer i = guruDao.insertBatchGuru(gurus);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public List<Guru> queryAll() {
        List<Guru> list = guruDao.selectAll();
        if (list.isEmpty()){
            return null;
        }
        return list;
    }
}
