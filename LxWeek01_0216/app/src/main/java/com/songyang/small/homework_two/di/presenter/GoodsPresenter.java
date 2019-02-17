package com.songyang.small.homework_two.di.presenter;


import android.util.Log;

import com.songyang.small.homework_two.data.entity.Root;
import com.songyang.small.homework_two.di.core.DataCall;
import com.songyang.small.homework_two.di.model.GoodsModel;

public class GoodsPresenter extends BasePresenter<DataCall> {
    private GoodsModel goodsModel;

    /**
     * 绑定View
     *
     * @param view
     */
    public GoodsPresenter(DataCall view) {
        super(view);
    }

    @Override
    protected void initModel() {
        goodsModel = new GoodsModel();
    }

    public void onGoodsPresenter() {
        goodsModel.onGoodsModel(new GoodsModel.GoodsModelCallBack() {

            @Override
            public void getSuccess(Root root) {
                Log.d("GoodsPresenter", root.getResult().getRxxp().get(0).getName());
                view.showGoodsSuccess(root);
            }

            @Override
            public void getFaid(Throwable error) {
                Log.d("GoodsPresenter", error.toString());
                view.showError(error);
            }
        });
    }
}
