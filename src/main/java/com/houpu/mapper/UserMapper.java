package com.houpu.mapper;

import com.houpu.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.swing.*;
import java.util.List;

public interface UserMapper {
    @Select("select * from t_user where userCode=#{userCode} and userPassword=#{userPassword}")
    User findByCodeAndPwd(@Param("userCode") String userCode,@Param("userPassword") String userPassword);

   /* @Select("select count(*) from t_user")*/
    int findTotlCount(@Param("userName") String userName,@Param("roleId") Integer role_id);

    /*@Select("select * from t_user limit #{index},#{size}")
    List<User> findAll(@Param("index") int index,@Param("size") int size);*/
    //多表关联查询
    List<User> findAll(@Param("index") int index,@Param("size") int size,@Param("userName") String userName,@Param("roleId") Integer role_id);

    void addUser(User user);

    @Select("select * from t_user where id=#{id}")
    User userview(int id);

    @Delete("delete  from t_user where id=#{id}")
    void toDelete(int id);

    @Update("update t_user set userCode=#{userCode},userName=#{userName},birthday=now(),phone=#{phone},address=#{address} where id=#{id};")
    void update(User user);

    void add(User user);

    @Update("update t_user set userPassword=#{newPwd} where id=#{id}")
    void pwd(@Param("id") int id,@Param("newPwd") String newPwd);
}
