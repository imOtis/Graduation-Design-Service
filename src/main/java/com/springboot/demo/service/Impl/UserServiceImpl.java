package com.springboot.demo.service.Impl;

import com.springboot.demo.entity.User;
import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create By SINYA
 * Create Date 2019/2/27
 * Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> getUserByAccount(User user) {
        List<User> resultList = userMapper.getUserByAccount(user);
        return resultList;
    }

    @Override
    public List<User> getAllUserInfo() {
        List<User> result = userMapper.getAllUserInfo();
        return result;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userMapper.deleteUser(Integer.parseInt(id));
    }
}