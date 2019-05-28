package com.dreambook.mapper;

import com.dreambook.doMain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public User findByUserName(@Param("username") String username);
}
