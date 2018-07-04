package com.baizhi.cmfz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * 密码加密工具
 * @author Administrator
 *
 */
public class EncryptionUtils {
	public static String encryption(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		byte[] code = md.digest(str.getBytes());

		StringBuilder builder = new StringBuilder();

		for (byte b : code) {
			// 1.将每个字节转换成无符号数（正数）
			int c = b & 0xFF;
			// 0000 0000 1111 1111 255
			// 1110 0001 -31
			// 0000 0000 1110 0001 225

			if (c < 16) {
				// 2.如果16以下的数字，转换十六进制后，不足2位数，则追加0作为前缀
				builder.append("0");
			}

			// 3.将该字节转换为十六进制字符串，进行拼接
			builder.append(Integer.toHexString(c));
		}
		return builder.toString();
	}
    /**
     * 生成64位的加密密码 
     * @param str
     * @return
     */
	public static String encryptionCodec(String str) {

		return DigestUtils.sha256Hex(str);
	}
    /**
     * 随机生成指定长度的字符串
     * @param len
     * @return
     */
	public static String getRandomSalt(int len) {
		char[] chs = "abcdefg1234567ABCDEFG".toCharArray();

		Random random = new Random();

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < len; i++) {
			builder.append(chs[random.nextInt(chs.length)]);
		}
		return builder.toString();
	}
	

}
