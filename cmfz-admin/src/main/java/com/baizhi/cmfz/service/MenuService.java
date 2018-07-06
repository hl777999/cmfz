package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Service
public interface MenuService {
    /**
     * 查询父级菜单
     * @param id
     * @return
     */
    public List<Menu> queryAllByLevel(String id);

    /**
     * 查询子菜单
     * @param levelid
     * @param parentid
     * @return
     */
    public List< Menu> queryAllByLevelAndParentid(String levelid,String parentid);

    /**
     * 查新所有的菜单列表
     * @param id
     * @return
     */
    public List<Menu> queryAll(String id);
}
