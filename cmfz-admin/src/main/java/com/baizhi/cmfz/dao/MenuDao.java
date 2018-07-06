package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单查询
 * Created by Administrator on 2018/7/5.
 */
public interface MenuDao {
    /**
     * 查询同一等级的菜单项
     * @param id
     * @return
     */
    public List<Menu> selectMenuByLevelAll(@Param("id") String id);

    /**
     * 查询同一等级且父菜单ID相同的菜单项
     * @param level_id
     * @param parent_id
     * @return
     */
    public List<Menu> selectMenuByLevelAndParentidAll(@Param("levelid") String level_id,@Param("parentid") String parent_id);

    /**
     * 查询所有的菜单
     * @param id
     * @return
     */
    public List<Menu> selectALL(@Param("id") String id);
}
