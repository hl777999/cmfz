package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Address;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface UserDao {
    public List<Address> selectBy(List<Address> addresses);
    public List<Address> selectByWomen(List<Address> addresses);
    public List<Address> selectToAddress();
}
