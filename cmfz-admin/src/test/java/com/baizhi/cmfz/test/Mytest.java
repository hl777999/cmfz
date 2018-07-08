package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test5(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuDao menuDao= (MenuDao) ctx.getBean("menuDao");
        List<Menu> menus = menuDao.selectMenuByLevelAll("1");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    @Test
    public void test6(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuDao menuDao= (MenuDao) ctx.getBean("menuDao");
        List<Menu> menus = menuDao.selectMenuByLevelAndParentidAll("2","1");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    @Test
    public void test7(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuService menuService= (MenuService) ctx.getBean("menuServiceImpl");
        //List<Menu> menus = menuService.queryAllByLevel("1");
        List<Menu> menus = menuService.queryAllByLevelAndParentid("2", "1");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void test8(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuDao menuDao= (MenuDao) ctx.getBean("menuDao");
        List<Menu> menus = menuDao.selectALL("1");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void test9(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureDao pictureDao= (PictureDao) ctx.getBean("pictureDao");
//        List<Picture> pictures = pictureDao.selectAll(0, 3);
//        for (Picture picture : pictures) {
//            System.out.println(picture);
//        }
        System.out.println(pictureDao.selectTotal());
    }

    @Test
    public void test10(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureService pictureService= (PictureService) ctx.getBean("pictureServiceImpl");
//        Map<String, Object> map = pictureService.queryAll(1, 3);
//        for (Map.Entry<String,Object> o : map.entrySet()) {
//            System.out.println(o);
//        }

    }

    @Test
    public void test11(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureDao pictureDao= (PictureDao) ctx.getBean("pictureDao");
        Integer integer = pictureDao.insertPic(new Picture("19", "5.gif", new Date(), "大召寺", "未使用"));
        System.out.println(integer);
    }

    @Test
    public void test12() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(date);
        Date parse = format.parse("2018-07-06 19:12:46");
        long time = date.getTime();
        System.out.println(time);
        System.out.println(parse);
        System.out.println(date);
        System.out.println(s);
        String s1 = format.format(time);
        System.out.println(s1);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
        Date date2 = new Date(date1.getTime());
        System.out.println(date2);
    }

    @Test
    public void  test13(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GuruDao guruDao= (GuruDao) ctx.getBean("guruDao");
        List<Guru> gurus = guruDao.selectAllGuru(0, 5, null, null, "已故");
        for (Guru guru : gurus) {
            System.out.println(guru);
        }
    }

    @Test
    public void  test14(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GuruDao guruDao= (GuruDao) ctx.getBean("guruDao");
//        Integer integer = guruDao.insertGuru(new Guru(null, "仁波切13", "2.jpg", "得到大法师", "健在", new Date()));
//        System.out.println(integer);
        List<Guru> list = guruDao.selectAll();
        for (Guru guru : list) {
            System.out.println(guru);
        }
    }

    @Test
    public void  test15(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
         GuruService guruService= (GuruService) ctx.getBean("guruServiceImpl");
        boolean b = guruService.modifyGuru(new Guru(15, "上师仁波切15", "2.jpg", "上乘大法师", "健在", null));
        if (b) {
            System.out.println("修改成功!");
        }
    }

    @Test
    public void  test16(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GuruDao guruDao= (GuruDao) ctx.getBean("guruDao");
        List<Guru> list=new ArrayList<>();
        list.add(new Guru(null,"12","123","123","123",new Date()));
        list.add(new Guru(null,"12","123","123","123",new Date()));
        list.add(new Guru(null,"12","123","123","123",new Date()));
        Integer integer = guruDao.insertBatchGuru(list);
        System.out.println(integer);
    }
}
