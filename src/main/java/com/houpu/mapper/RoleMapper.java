package com.houpu.mapper;

import com.houpu.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    Role findRoleById(int id);

    @Select("select * from t_role")
    List<Role> findAll();
}
