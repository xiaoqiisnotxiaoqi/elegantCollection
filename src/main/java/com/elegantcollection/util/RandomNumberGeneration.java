package com.elegantcollection.util;

import java.util.Random;

public class RandomNumberGeneration {

    /**
     * 生成一个长度为 length 的随机字符串
     * @param length 要生成的字符串长度
     * @return 随机生成的长度为 length 的字符串
     */
    public static String getRandomString(int length){
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<length;i++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            return sb.toString();
    }


}
