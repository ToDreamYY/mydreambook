package com.dreambook.service;

import com.dreambook.doMain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findByUserName(String username);

    List<Map> findRolesAndMenusByUid(String uid);
}
