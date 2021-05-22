package com.senmiao.mapper;

import com.senmiao.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Select("select id,username,password,nickname from user")
    User selectById(Integer id);
}
