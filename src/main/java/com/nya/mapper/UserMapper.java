package com.nya.mapper;

import com.nya.entity.User;

import java.util.List;

/**
 * @Author: nya
 * @Date: 18-5-21 下午1:48
 */
public interface UserMapper {

    int insert(User user);

    List<User> selectAllUser();

    User selectById(Integer userId);
}
