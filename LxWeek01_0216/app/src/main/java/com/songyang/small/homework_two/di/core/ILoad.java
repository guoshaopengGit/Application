package com.songyang.small.homework_two.di.core;

import com.songyang.small.homework_two.data.Constant.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ILoad {
    @GET(Constant.GOODS_PATH)
    Observable<String> showGoods();

    @GET(Constant.BANNER_PATH)
    Observable<String> showBanner();
}
