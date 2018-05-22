package com.nya.controller;

import com.nya.entity.ExampleConfig;
import com.nya.entity.User;
import com.nya.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: nya
 * @Date: 18-5-21 下午2:43
 */
@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @Qualifier("userServiceTestImpl")
    @Autowired
    private UserService userServiceTest;

    // 自定义属性的使用
    @Value(value = "${test.scope}")
    private String scope;

    // 自定义配置文件对应配置类 注入
    @Autowired
    private ExampleConfig exampleConfig;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    @ResponseBody
    public float sayHi(){
        return Float.parseFloat(scope);
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return exampleConfig.getName() + "的老婆是"
                + exampleConfig.getWife() + ", 年龄" + exampleConfig.getAge()
                + "岁，梦想是" + exampleConfig.getDream();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public int addUser(User user){
        logger.info("addUser--param:"+user.toString());
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        List<User> list = userService.getAllUser(pageNum,pageSize);
        logger.info("query--list:"+list.toString());
        return list;
    }

    @RequestMapping(value = "one/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id")Integer userId){
        User user = userServiceTest.getUserById(userId);
        logger.info("getUserById--result:"+user.toString());
        return user;
    }

}
