package com.songyang.small.homework_two.di.model;

import com.google.gson.Gson;
import com.songyang.small.homework_two.base.BaseObserver;
import com.songyang.small.homework_two.data.entity.BannerEntity;
import com.songyang.small.homework_two.data.utils.RetrofitUtil;
import com.songyang.small.homework_two.di.core.ILoad;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BannerModel {
    public void onBannerModel(final BannerModelCallBack bannerModelCallBack) {
        //获取工具类对象
        RetrofitUtil.getRetrofitUtil().create(ILoad.class).showBanner()
                //订阅者
                .subscribeOn(Schedulers.io())
                //观察者
                .observeOn(AndroidSchedulers.mainThread())
                //订阅对象
                .subscribe(new BaseObserver() {
                    @Override
                    public void onSuccess(String s) {
                        BannerEntity bannerEntity = new Gson().fromJson(s, BannerEntity.class);
                        bannerModelCallBack.getSuccess(bannerEntity);
                    }

                    @Override
                    public void onFailed(Throwable e) {
                        bannerModelCallBack.getFaid(e);
                    }
                });
    }

    //接口回调
    public interface BannerModelCallBack {
        void getSuccess(BannerEntity bannerEntity);

        void getFaid(Throwable error);
    }
}
