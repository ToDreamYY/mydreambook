package com.dreambook.mapper;

import com.dreambook.doMain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    User findByUserName(@Param("username") String username);

    List<Map> findRolesAndMenusByUid(String uid);
}
