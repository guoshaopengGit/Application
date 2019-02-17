package com.songyang.small.homework_two.di.presenter;


import com.songyang.small.homework_two.data.entity.BannerEntity;
import com.songyang.small.homework_two.di.core.DataCall;
import com.songyang.small.homework_two.di.model.BannerModel;

public class BannerPresenter extends BasePresenter<DataCall> {
    private BannerModel bannerModel;

    /**
     * 绑定View
     *
     * @param view
     */
    public BannerPresenter(DataCall view) {
        super(view);
    }

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
    }

    public void onBannerPresenter() {
        bannerModel.onBannerModel(new BannerModel.BannerModelCallBack() {
            @Override
            public void getSuccess(BannerEntity bannerEntity) {
                view.showBanner(bannerEntity);
            }

            @Override
            public void getFaid(Throwable error) {
                view.showError(error);
            }
        });
    }
}
