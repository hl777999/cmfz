package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Map<String,Object> queryAllGuru(Integer newPage,Integer pageSize,Integer guruid,String guruname,String status);

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
    public  boolean removeGuru(Integer id);

    /**
     * 批量添加上师信息
     * @param gurus
     * @return
     */
    public  boolean batchAddGuru(List<Guru> gurus);

    /**
     * 查询所有上师信息
     * @return
     */
    public  List<Guru> queryAll();
}
