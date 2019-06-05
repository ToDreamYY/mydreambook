package com.dreambook.service.impl;

import com.dreambook.mapper.PermissionMapper;
import com.dreambook.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /*查询所有管理员*/
    @Override
    public Map getAllAdmin(String keyWord, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Map> list = permissionMapper.getAllAdmin(keyWord);
        System.out.println(list.size());
        PageInfo<Map> info = new PageInfo();
        info.setList(list);
        System.out.println(info);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", info.getTotal());
        map.put("data", info.getList());
        return map;
    }
}
