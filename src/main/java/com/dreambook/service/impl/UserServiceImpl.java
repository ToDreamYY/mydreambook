package com.dreambook.service.impl;

import com.dreambook.doMain.User;
import com.dreambook.mapper.UserMapper;
import com.dreambook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<Map> findRolesAndMenusByUid(String uid) {
        return userMapper.findRolesAndMenusByUid(uid);
    }
}
