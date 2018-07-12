package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.*;
import com.baizhi.cmfz.entity.*;
import com.baizhi.cmfz.service.*;
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
        Manager manager = managerDao.selectById(123);
        System.out.println(manager);
    }
    @Test
    public void test2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerDao= (ManagerDao) ctx.getBean("managerDao");
        String salt = EncryptionUtils.getRandomSalt(6);
        Manager manager=new Manager(125,"admin3",EncryptionUtils.encryptionCodec("123456"+salt),salt,"超级管理员");
        Integer i = managerDao.insertManager(manager);
        System.out.println("---------------"+i);
    }
    @Test
    public void test3(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService= (ManagerService) ctx.getBean("managerServiceImpl");
//        Manager manager = managerService.queryByIdandPwd(125, "123456");
//        System.out.println(manager);
        Manager manager = managerService.queryById(123);
        System.out.println(manager);
    }

    @Test
    public void test4(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService= (ManagerService) ctx.getBean("managerServiceImpl");
        boolean b = managerService.addManger(new Manager(126, "admin3", "123456", null, "一般管理员"));
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
//        Address<String, Object> map = pictureService.queryAll(1, 3);
//        for (Address.Entry<String,Object> o : map.entrySet()) {
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
//        GuruDao guruDao= (GuruDao) ctx.getBean("guruDao");
//        Integer integer = guruDao.insertGuru(new Guru(null, "仁波切13", "2.jpg", "得到大法师", "健在", new Date()));
//        System.out.println(integer);
//        List<Guru> list = guruDao.selectAll();
//        for (Guru guru : list) {
//            System.out.println(guru);
//        }
        GuruService guruService= (GuruService) ctx.getBean("guruServiceImpl");
        List<Guru> gurus = guruService.queryAll();
        for (Guru guru : gurus) {
            System.out.println(guru);
        }
    }

    @Test
    public void  test15(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
         GuruService guruService= (GuruService) ctx.getBean("guruServiceImpl");
//        boolean b = guruService.modifyGuru(new Guru(15, "上师仁波切15", "2.jpg", "上乘大法师", "健在", null));
//        if (b) {
//            System.out.println("修改成功!");
//        }
        Map<String, Object> map = guruService.queryAllGuru(1, 5, null, null, null);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry);
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

    @Test
    public void  test17() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ArticleService articleService= (ArticleService) ctx.getBean("articleServiceImpl");
        boolean b = articleService.addArticle(new Article(null, "111", 1, "123", new Date(), "未上架"));
        if (b) {
            System.out.println("插入成功");
        }
    }

    @Test
    public void  test18() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
//        List<Address> list=new ArrayList<>();
//        list.add(new Address("北京"));
//        list.add(new Address("河南"));
//        list.add(new Address("河北"));
//        //List<Address> addresses = userDao.selectBy(list);
//        List<Address> addresses = userDao.selectByWomen(list);
//        for (Address address : addresses) {
//            System.out.println(address);
//        }

        List<Address> addresses = userDao.selectToAddress();
        for (Address address : addresses) {
            System.out.println(address);
        }

    }
        @Test
        public void test19(){
            ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
            LogDao logDao= (LogDao) ctx.getBean("logDao");
//            List<Log> logs = logDao.selectAll();
//            for (Log log : logs) {
//                System.out.println(log);
//            }
        }

    @Test
    public void test20(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RoleDao roleDao= (RoleDao) ctx.getBean("roleDao");
//        List<Role> roles = roleDao.selectByIdtoRole(123);
//        for (Role role : roles) {
//            System.out.println(role);
//        }

        List<Permission> permissions = roleDao.selectByIdtoPermission(123);
        for (Permission permission : permissions) {
            System.out.println(permission);
        }
    }
}
