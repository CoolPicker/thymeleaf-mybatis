package com.nya.controller;

import com.nya.entity.User;
import com.nya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @Qualifier("userServiceTestImpl")
    @Autowired
    private UserService userServiceTest;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public int addUser(User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        return userService.getAllUser(pageNum,pageSize);
    }

    @RequestMapping(value = "one/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id")Integer userId){
        return userServiceTest.getUserById(userId);
    }

}
