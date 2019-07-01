package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;
import com.kgc.house.entity.StreetExample;

import java.util.List;

public interface StreetService {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    //通过区域删除街道的业务
    int deleltStreetByDid(Integer id);

    //通过区域显示街道
    PageInfo<Street> getStreetByDistrict(Integer page, Integer pageSize, Integer districtId);

    List<Street> getStreetByDistrict(Integer districtId);

}
