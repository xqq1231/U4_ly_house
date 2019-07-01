package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;

import java.util.List;

public interface DistrictService {

    //分页查询
    PageInfo<District> getDistrictByPage(Integer page,Integer pageSize);

    public int addDistrict(District district);

    public int updateDistrict(District district);

    public int deleteDistrict(Integer id);

    int deleteMoreDistrict(Integer[] ids);

    List<District> getAllDistrict();
}
