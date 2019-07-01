package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.UserCondition;
import com.kgc.house.entity.Users;

public interface UserService {
    //查询所有用户
    PageInfo<Users> getUsersByPage(UserCondition condition);
    //检查用户名是否存在
    public int checkUname(String username);
    //添加用户  注册
    public int addUsers(Users users);

    //实现登入
    public Users login(String username,String password);
}
