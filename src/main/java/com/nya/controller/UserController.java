package com.nya.controller;

import com.nya.entity.ExampleConfig;
import com.nya.entity.User;
import com.nya.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "用户相关API",tags = {"用户操作接口"})
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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

    @ApiOperation(value = "自定义配置-项目路径",notes = "项目路径下的自定义配置信息")
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    @ResponseBody
    public float sayHi(){
        return Float.parseFloat(scope);
    }

    @ApiOperation(value = "自定义配置-本地路径",notes = "本地路径下的自定义配置文件中的配置信息获取")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return exampleConfig.getName() + "的老婆是"
                + exampleConfig.getWife() + ", 年龄" + exampleConfig.getAge()
                + "岁，梦想是" + exampleConfig.getDream();
    }

    @ApiOperation(value = "新增用户",notes = "新增用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "ID",paramType = "query",dataType = "integer"),
            @ApiImplicitParam(name = "userName",value = "用户名",paramType = "query",required = true),
            @ApiImplicitParam(name = "password",value = "密码",paramType = "query"),
            @ApiImplicitParam(name = "phone",value = "手机",paramType = "query")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public int addUser(User user){
        logger.info("addUser--param:"+user.toString());
        return userService.addUser(user);
    }

    @ApiOperation(value = "用户列表",notes = "分页获取用户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页码",paramType = "path",required = true,dataType = "integer"),
            @ApiImplicitParam(name = "pageSize",value = "显示条数",paramType = "path",required = true,dataType = "integer")
    })
    @RequestMapping(value = "/all/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        List<User> list = userService.getAllUser(pageNum,pageSize);
        logger.info("query--list:"+list.toString());
        return list;
    }

    @ApiOperation(value = "id查用户",notes = "获取数据库中具体某个用户的详细信息")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "path",required = true,dataType = "integer")
    @RequestMapping(value = "one/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id")Integer userId){
        User user = userServiceTest.getUserById(userId);
        logger.info("getUserById--result:"+user.toString());
        return user;
    }

}
