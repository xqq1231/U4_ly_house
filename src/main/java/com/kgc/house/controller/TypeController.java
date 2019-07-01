package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Type;
import com.kgc.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("getType")
    @ResponseBody
    public Map<String,Object> getType(Integer page,Integer rows){
        //调用业务
        PageInfo<Type> pageInfo=typeService.getTypeByPage(page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("addType")
    @ResponseBody
    public String addType(Type type){
        int i = typeService.addType(type);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("upType")
    @ResponseBody
    public String upType(Type type){
        int i = typeService.updateType(type);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("delType")
    @ResponseBody
    public String delType(Integer id){
        int i = typeService.deleteType(id);
        return "{\"result\":"+i+"}";
    }
    /**
     * 批量删除的控制器
     */
    @RequestMapping("delMoreType")
    @ResponseBody
    public String delMoreType(String ids){
        String[] arys = ids.split(",");
        Integer[] id=new Integer[arys.length];
        for(int i=0;i<arys.length;i++){
            id[i]=Integer.parseInt(arys[i]);
        }
        //调用业务
        int i = typeService.deleteMoreType(id);
        return "{\"result\":"+i+"}";
    }
}
