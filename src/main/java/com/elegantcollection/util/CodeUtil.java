package com.elegantcollection.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    /**
     * 图片 验证码校验
     * @param request 请求信息
     * @return 验证用户输入的验证码是否正确
     */
    public static boolean checkVerifyCode(HttpServletRequest request,String imgCode) {
        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //获取用户输入的验证码
        return verifyCodeExpected.equals(imgCode);
    }
}
