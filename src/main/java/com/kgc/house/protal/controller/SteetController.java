package com.kgc.house.protal.controller;

import com.kgc.house.entity.Street;
import com.kgc.house.service.StreetService;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("steetController2")
@RequestMapping("/page/")
public class SteetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetByDid2")
    @ResponseBody
    public List<Street> etStreetByDid2(Integer did){
        //调用业务
        return streetService.getStreetByDistrict(did);
    }
}
