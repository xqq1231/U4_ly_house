package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Type;

import java.util.List;

public interface TypeService {
    //查询区域带分页
    PageInfo<Type> getTypeByPage(Integer page,Integer pageSize);

   //添加区域
    public int addType(Type type);

    //修改区域
    public int updateType(Type type);

    //删除区域
    public int deleteType(Integer id);

    //批量删除
    int deleteMoreType(Integer[] ids);
    //查询所有
    List<Type> getAllType();
}
