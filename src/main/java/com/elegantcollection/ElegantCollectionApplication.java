package com.elegantcollection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@ServletComponentScan
@MapperScan("com.elegantcollection.dao")
@SpringBootApplication
@EnableCaching
public class ElegantCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElegantCollectionApplication.class, args);
	}
}
