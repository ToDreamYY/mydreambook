package com.dreambook.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface PermissionService {
     /*查询所有管理员*/
    Map getAllAdmin(String keyWord, Integer pageNum, Integer limit);
}
