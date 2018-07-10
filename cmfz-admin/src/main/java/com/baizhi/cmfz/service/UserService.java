package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public interface UserService {
   public List<Address> queryMan();
   public List<Address> queryWomen();
}
