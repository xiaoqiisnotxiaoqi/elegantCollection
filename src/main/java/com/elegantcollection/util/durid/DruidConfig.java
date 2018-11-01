package com.elegantcollection.util.durid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration//标识该类被纳入spring容器中实例化并管理

@ServletComponentScan// 用于扫描所有的Servlet、filter、listener ,并实例化
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource") //可以把同类的配置信息自动封装成实体类
    @Primary //在同样的DataSource中，首先使用被标注的DataSource
    //加载时读取指定的配置信息,前缀为spring.datasource.druid

    public DataSource druidDataSource() {
        return new DruidDataSource();


    }
}
