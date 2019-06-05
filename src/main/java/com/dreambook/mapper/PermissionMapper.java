package com.dreambook.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PermissionMapper {
    /*查询所有管理员*/
    List<Map> getAllAdmin(@Param("keyWord") String keyWord);
}
