package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/6.
 */
@Service
public interface GuruService {

    /**
     * 按条件分页查询上师信息
     * @param newPage
     * @param pageSize
     * @param guruid
     * @param guruname
     * @param status
     * @return
     */
    public Map<String,Object> queryAllGuru(Integer newPage,Integer pageSize,String guruid,String guruname,String status);

    /**
     * 插入上师信息
     * @param guru
     * @return
     */
    public boolean insertGuru(Guru guru);

    /**
     * 修改上师信息
     * @param guru
     * @return
     */
    public boolean modifyGuru(Guru guru);

    /**
     * 删除上师信息
     * @param id
     * @return
     */
    public  boolean removeGuru(String id);
}
