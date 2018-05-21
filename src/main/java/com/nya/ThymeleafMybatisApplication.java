package com.nya;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.nya.mapper")
public class ThymeleafMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafMybatisApplication.class, args);
	}
}
