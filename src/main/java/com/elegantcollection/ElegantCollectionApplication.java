package com.elegantcollection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@ServletComponentScan
@MapperScan("com.elegantcollection.dao")
@SpringBootApplication
@EnableCaching
public class ElegantCollectionApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ElegantCollectionApplication.class, args);
	}

	//为了打包springboot项目
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
