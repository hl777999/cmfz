package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Mytest {
    @Test
    public void test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerDao= (ManagerDao) ctx.getBean("managerDao");
        Manager manager = managerDao.selectById("123");
        System.out.println(manager);
    }
    @Test
    public void test2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerDao= (ManagerDao) ctx.getBean("managerDao");
        String salt = EncryptionUtils.getRandomSalt(6);
        Manager manager=new Manager("125","admin3",EncryptionUtils.encryptionCodec("123456"+salt),salt,"超级管理员");
        Integer i = managerDao.insertManager(manager);
        System.out.println("---------------"+i);
    }
    @Test
    public void test3(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService= (ManagerService) ctx.getBean("managerServiceImpl");
        Manager manager = managerService.login("125", "123456");
        System.out.println(manager);
    }

    @Test
    public void test4(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService= (ManagerService) ctx.getBean("managerServiceImpl");
        boolean b = managerService.regist(new Manager("李四", "admin3", "123456", null, "一般管理员"));
        if (b){
            System.out.println("注册成功");
        }
    }
}
