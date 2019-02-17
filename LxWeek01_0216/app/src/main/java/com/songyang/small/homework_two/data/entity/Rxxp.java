package com.songyang.small.homework_two.data.entity;

import java.util.List;

public class Rxxp {
    private List<CommodityList> commodityList;

    private int id;

    private String name;

    public void setCommodityList(List<CommodityList> commodityList) {
        this.commodityList = commodityList;
    }

    public List<CommodityList> getCommodityList() {
        return this.commodityList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
