package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    @Transactional(readOnly = true)
    public Manager login(String id, String password) {
        Manager manager = managerDao.selectById(id);
        if (manager!=null && manager.getMgrpwd().equals(EncryptionUtils.encryptionCodec(password+manager.getMgrsalt()))){
            return manager;
        }
        return null;
    }

    @Override
    @Transactional
    public boolean regist(Manager manager) {
        String salt = EncryptionUtils.getRandomSalt(6);
        manager.setMgrsalt(salt);
        manager.setMgrpwd(EncryptionUtils.encryptionCodec(manager.getMgrpwd()+salt));
        Integer i = managerDao.insertManager(manager);
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Manager queryById(String id) {
        Manager manager = managerDao.selectById(id);
        return manager;
    }
}
