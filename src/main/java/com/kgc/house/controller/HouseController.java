package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.House;
import com.kgc.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("HouseController2")
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    //查询未审核
    @RequestMapping("getHouseByNoPass")
    @ResponseBody
    public Map<String,Object> getHouseByNoPass(Integer page,Integer rows){
        PageInfo<House> paegInfo=houseService.getHouseByState(page,rows,0);
        Map<String,Object> map=new HashMap<>();
        map.put("total",paegInfo.getTotal());
        map.put("rows",paegInfo.getList());
        return map;
    }
    //查询已审核
    @RequestMapping("getHouseByYesPass")
    @ResponseBody
    public Map<String,Object> getHouseByYesPass(Integer page,Integer rows){
        PageInfo<House> paegInfo=houseService.getHouseByState(page,rows,1);
        Map<String,Object> map=new HashMap<>();
        map.put("total",paegInfo.getTotal());
        map.put("rows",paegInfo.getList());
        return map;
    }

    //通过审核
    @RequestMapping("passHouse")
    public Map<String,Object>  passHouse(String id){
        int i = houseService.passHouse(id);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
}
