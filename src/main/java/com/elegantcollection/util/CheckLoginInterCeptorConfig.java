package com.elegantcollection.util;

import com.elegantcollection.controller.CheckLoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class CheckLoginInterCeptorConfig extends WebMvcConfigurerAdapter {
    /**
     * denglu拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPattern后跟拦截地址，excludePathPatterns后跟排除拦截地址
        registry.addInterceptor(new CheckLoginInterceptor()).
                excludePathPatterns("/login").
                addPathPatterns("/loginOut").addPathPatterns("/getMyEvaluate").addPathPatterns("/book/add2Cart")
                .addPathPatterns("/myaddress").addPathPatterns("/myelegant");
    }
}
