package com.nya.service.impl;

import com.github.pagehelper.PageHelper;
import com.nya.entity.User;
import com.nya.mapper.UserMapper;
import com.nya.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: nya
 * @Date: 18-5-21 下午2:41
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;


    @Override
    public int addUser(User user) {
        logger.info("insert--user--params:"+user);
        return userMapper.insert(user);
    }

    @Override
    public List<User> getAllUser(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    public User getUserById(Integer userId) {
        return null;
    }
}
