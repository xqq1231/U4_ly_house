package com.kgc.house.mapper;

import com.kgc.house.entity.House;
import com.kgc.house.entity.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询所有出租房
    List<House> selectHouseByUserId(Integer uid);

    //查询出租房信息（带区域id）
    House getHouseAndDid(String id);

    List<House> getHouseByState(Integer state);
}