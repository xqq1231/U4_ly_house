package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;
import com.kgc.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class SteetController {
    @Autowired
    private StreetService streetService;
 @RequestMapping("getStreetByDid")
  @ResponseBody
    public Map<String,Object> getUsers(Integer page,Integer rows,Integer did){
     //调用业务
     PageInfo<Street> pageInfo = streetService.getStreetByDistrict(page, rows, did);
     Map<String,Object> map=new HashMap<>();
     map.put("total",pageInfo.getTotal());
     map.put("rows",pageInfo.getList());
     return map;
 }
}
