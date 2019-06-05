package com.dreambook.controller;

import com.dreambook.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permission")
public class PermissionComtroller {

        @Autowired
        private PermissionService permissionService;
        @RequestMapping("/getAllAdmin")
        public Map getAllAdmin(String keyWord, Integer pageNum, Integer limit) {
            Map data=permissionService.getAllAdmin(keyWord,pageNum,limit);
            System.out.println(data);
            return data;
        }

}
