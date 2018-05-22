package com.nya.service.impl;

import com.nya.entity.User;
import com.nya.mapper.UserMapper;
import com.nya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: nya
 * @Date: 18-5-21 下午7:18
 */
@Service
public class UserServiceTestImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public List<User> getAllUser(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectById(userId);
    }
}
