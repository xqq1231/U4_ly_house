package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("getDistrict")
    @ResponseBody
    public Map<String,Object> selectDistrictByPage (Integer page,Integer rows){
        PageInfo<District> pageInfo=districtService.getDistrictByPage(page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("addDistrict")
    @ResponseBody
    public String addDistrict(District district){
        int i = districtService.addDistrict(district);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("upDistrict")
    @ResponseBody
    public String upDistrict(District district){
        int i = districtService.updateDistrict(district);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("delDistrict")
    @ResponseBody
    public String delDistrict(Integer id){
      //调用业务
      int i = districtService.deleteDistrict(id);
      return "{\"result\":"+i+"}";
  }

    /**
     * 批量删除的控制器
     */

    @RequestMapping("delMoreDistrict")
    @ResponseBody
    public String delDistrict(String ids){
        String[] arys=ids.split(",");
        Integer[] id=new Integer[arys.length];
        for(int i=0;i<arys.length;i++){
           id[i] = Integer.parseInt(arys[i]);
        }
        int i = districtService.deleteMoreDistrict(id);
        return "{\"result\":"+i+"}";
    }
}
