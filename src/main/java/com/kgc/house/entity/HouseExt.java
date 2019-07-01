package com.kgc.house.entity;

/**
 * @author 王建兵
 * @Classname HouseExt
 * @Description TODO
 * @Date 2019/6/25 14:21
 * @Created by Administrator
 */
public class HouseExt extends  House {

    private String sname; //存街道名称
    private String dname; //区域名称
    private String tname; //类型名称

    @Override
    public String getSname() {
        return sname;
    }

    @Override
    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String getDname() {
        return dname;
    }

    @Override
    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String getTname() {
        return tname;
    }

    @Override
    public void setTname(String tname) {
        this.tname = tname;
    }
}
