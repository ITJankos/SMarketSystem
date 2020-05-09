package com.houpu.service.impl;

import com.houpu.domain.PageBean;
import com.houpu.domain.User;
import com.houpu.mapper.UserMapper;
import com.houpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userCode, String userPassword) {
        return userMapper.findByCodeAndPwd(userCode, userPassword);
    }

    @Override
    public PageBean<User> findByPage(String pageNum, String pageSize, String username, String roleId) {
        int num = Integer.parseInt(pageNum);
        int size = Integer.parseInt(pageSize);
        Integer role_id=null;
        if (roleId!=null && roleId!=""){
             role_id = Integer.parseInt(roleId);
             if (role_id==0){
                 role_id=null;
             }
        }

        //查询总记录数
        int totalCount = userMapper.findTotlCount(username,role_id);
        //计算总页数
        Integer totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
        /*查询具体的分页数据*/
        int index = (num - 1) * size;
        List<User> userList = userMapper.findAll(index, size,username,role_id);

        PageBean<User> pageBean = new PageBean<>();
        pageBean.setPageNum(num);
        pageBean.setPageSize(size);
        pageBean.setTotalCount(totalCount);
        pageBean.setList(userList);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User userview(int id) {
        return userMapper.userview(id);
    }
    //删除用户
    @Override
    public void toDelete(int id) {
         userMapper.toDelete(id);
    }
    //修改用户信息
    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void pwd(int id,String newPwd) {
        userMapper.pwd(id,newPwd);
    }


}
