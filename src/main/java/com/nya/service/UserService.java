package com.nya.service;

import com.nya.entity.User;
import java.util.List;

/**
 * @Author: nya
 * @Date: 18-5-21 下午2:40
 */
public interface UserService {

    int addUser(User user);

    List<User> getAllUser(int pageNum,int pageSize);

    User getUserById(Integer userId);

}
