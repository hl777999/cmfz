package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserDao;
import com.baizhi.cmfz.entity.Address;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<Address> queryMan() {

        List<Address> addresses = userDao.selectBy(userDao.selectToAddress());
        if (addresses.isEmpty()){
            return null;
        }
        return addresses;
    }

    @Override
    public List<Address> queryWomen() {
        List<Address> addresses = userDao.selectByWomen(userDao.selectToAddress());
        if (addresses.isEmpty()){
            return null;
        }
        return addresses;
    }

}
