package com.nya;

import com.nya.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafMybatisApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(ThymeleafMybatisApplication.class);

	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() {
		String hello = userController.sayHello();
		logger.info("SpringBootTest:"+hello);
	}

}
