package com.example.demo.mapper;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where account = #{account}")
    User findByAccount(String account);

    @Select("select * from user where account = #{account}")
    User findByUserName(String userName);
}
