package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.House;
import com.kgc.house.mapper.HouseMapper;
import com.kgc.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getUserHouseByPage(Integer page, Integer rows, Integer uid) {
        PageHelper.startPage(page,rows);
        List<House> list = houseMapper.selectHouseByUserId(uid);
        return new PageInfo<House>(list);
    }

    @Override
    public House getHouse(String id) {
        return houseMapper.getHouseAndDid(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouse(String id) {
        House house=new House();

        house.setId(id);
        house.setIsdel(new Integer(1));
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByState(Integer page, Integer row, Integer ispass) {
        PageHelper.startPage(page,row);
        List<House> list=houseMapper.getHouseByState(ispass);

        return new PageInfo<>(list);
    }

    @Override
    public int passHouse(String id) {
        House house=new House();
        house.setId(id);
        house.setIspass(1);//通过审核
        return houseMapper.updateByPrimaryKeySelective(house);
    }

}
