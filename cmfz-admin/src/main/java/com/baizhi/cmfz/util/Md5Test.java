package com.baizhi.cmfz.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Administrator on 2018/7/11.
 */
public class Md5Test {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456","huanglei",512);
        System.out.println(md5Hash);
    }
}
