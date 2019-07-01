package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;
import com.kgc.house.entity.StreetExample;
import com.kgc.house.mapper.StreetMapper;
import com.kgc.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StreetServiceImpl implements StreetService

{
    @Autowired
    private StreetMapper streetMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Street record) {
        return 0;
    }

    @Override
    public int insertSelective(Street record) {
        return 0;
    }

    @Override
    public List<Street> selectByExample(StreetExample example) {

        return null;
    }

    @Override
    public Street selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Street record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Street record) {
        return 0;
    }

    @Override
    public int deleltStreetByDid(Integer id) {
        return 0;
    }

    //分页查询全部
    @Override
    public PageInfo<Street> getStreetByDistrict(Integer page, Integer pageSize, Integer districtId) {
        PageHelper.startPage(page,pageSize);
        //查询街道
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(districtId);

        List<Street> list = streetMapper.selectByExample(streetExample);
        return new PageInfo<>(list);
    }

    @Override
    public List<Street> getStreetByDistrict(Integer districtId) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(districtId);

        List<Street> list = streetMapper.selectByExample(streetExample);
        return list;
    }

}
