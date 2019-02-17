package com.songyang.small.homework_two.data.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class CommodityList implements MultiItemEntity {
    private int commodityId;

    private String commodityName;

    private String masterPic;

    private int price;

    private int saleNum;

    public static final int TEXT = 0;
    public static final int IMG = 1;
    private int itemType = 0;

    public CommodityList(int itemType) {
        this.itemType = itemType;
    }

        @Override
    public int getItemType() {

        int i = getCommodityName().length()%2;
        //Log.e("ramder", "getItemType: "+i+"     "+getCommodityName().length()+"" );
        itemType = i;
        return itemType;
    }
    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getCommodityId() {
        return this.commodityId;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getMasterPic() {
        return this.masterPic;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getSaleNum() {
        return this.saleNum;
    }

}