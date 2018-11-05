package com.elegantcollection.util;

import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

public class Md5 {
    /**
     * 加密
     * @param password 用户密码
     * @return 加密后的 字段 以及 盐值
     */
    public static Map<String,String> getMd5(String password) {
        //随机生成一个 盐值
        String salt = RandomNumberGeneration.getRandomString(8);
        //将密码与 盐值一起 作为要加密 字段
        String base = password + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        Map<String,String> map = new HashMap<>();
        map.put("md5",md5);
        map.put("secklillId",salt);
        return map;
    }


    /**
     * 验证用户输入密码是否正确
     * @param password 用户输入的密码
     * @param salt 用户的 盐值
     * @param md5 用户 的密码(加密状态)
     * @return 正确 "true" 错误 "false"
     */
    public static boolean passwordEncryptionVerification(String password,String salt,String md5){
        String base = password + salt;
        String md = DigestUtils.md5DigestAsHex(base.getBytes());
        return md.equals(md5);
    }

}
