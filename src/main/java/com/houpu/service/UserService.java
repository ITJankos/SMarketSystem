package com.houpu.service;

import com.houpu.domain.PageBean;
import com.houpu.domain.User;

public interface UserService {
    User login(String userCode, String userPassword);



    PageBean<User> findByPage(String pageNum, String pageSize, String username, String roleId);

    void addUser(User user);

    User userview(int id);

    void toDelete(int id);

    void update(User user);

    void add(User user);

    void pwd(int id,String newPwd);
}
