package com.songyang.small.homework_two.di.model;

import com.google.gson.Gson;
import com.songyang.small.homework_two.base.BaseObserver;
import com.songyang.small.homework_two.data.entity.Root;
import com.songyang.small.homework_two.data.utils.RetrofitUtil;
import com.songyang.small.homework_two.di.core.ILoad;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GoodsModel {
    public void onGoodsModel(final GoodsModelCallBack goodsModelCallBack) {
//        OkGo.<String>get("http://172.17.8.100/small/commodity/v1/commodityList")
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        String s = response.body().toString();
//                        Root root = new Gson().fromJson(s, Root.class);
//                        goodsModelCallBack.getSuccess(root);
//                    }
//                });
        //获取工具类对象
        RetrofitUtil.getRetrofitUtil().create(ILoad.class).showGoods()
                //订阅者
                .subscribeOn(Schedulers.io())
                //观察者
                .observeOn(AndroidSchedulers.mainThread())
                //订阅对象
                .subscribe(new BaseObserver() {
                    @Override
                    public void onSuccess(String s) {

                        Root root = new Gson().fromJson(s, Root.class);
                        goodsModelCallBack.getSuccess(root);
                    }

                    @Override
                    public void onFailed(Throwable e) {
                        goodsModelCallBack.getFaid(e);
                    }
                });
    }

    //接口回调
    public interface GoodsModelCallBack {
        void getSuccess(Root root);

        void getFaid(Throwable error);
    }
}
