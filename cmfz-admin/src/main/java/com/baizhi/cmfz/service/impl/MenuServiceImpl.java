package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
   @Autowired
    private MenuDao menuDao;

    @Override
    @Transactional(readOnly = true)
    public List<Menu> queryAllByLevel(String id) {
        List<Menu> menus = menuDao.selectMenuByLevelAll(id);
        if (menus.isEmpty()){
            return null;
        }
        return menus;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> queryAllByLevelAndParentid(String levelid, String parentid) {
        List<Menu> menus = menuDao.selectMenuByLevelAndParentidAll(levelid, parentid);
        if (menus.isEmpty()){
            return null;
        }
        return menus;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> queryAll(String id) {
        List<Menu> menus = menuDao.selectALL("1");
        if (menus.isEmpty()){
            return null;
        }
        return menus;
    }
}
