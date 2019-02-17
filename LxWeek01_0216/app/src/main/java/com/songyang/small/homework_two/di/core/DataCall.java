package com.songyang.small.homework_two.di.core;


import com.songyang.small.homework_two.data.entity.BannerEntity;
import com.songyang.small.homework_two.data.entity.Root;

public interface DataCall extends IView {
    void showGoodsSuccess(Root root);

    void showBanner(BannerEntity bannerEntity);

    void showError(Throwable error);
}
