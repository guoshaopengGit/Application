package com.songyang.small.homework_two.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.ImageView;
import android.widget.Toast;

import com.songyang.small.homework_two.R;
import com.songyang.small.homework_two.data.adapters.GoodsAdapters;
import com.songyang.small.homework_two.data.app.HomeImageLoader;
import com.songyang.small.homework_two.data.entity.BannerEntity;
import com.songyang.small.homework_two.data.entity.CommodityList;
import com.songyang.small.homework_two.data.entity.Result;
import com.songyang.small.homework_two.data.entity.Root;
import com.songyang.small.homework_two.di.core.DataCall;
import com.songyang.small.homework_two.di.presenter.BannerPresenter;
import com.songyang.small.homework_two.di.presenter.GoodsPresenter;
import com.sunfusheng.marqueeview.MarqueeView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements DataCall {

    @BindView(R.id.img_sys)
    ImageView imgSys;
    @BindView(R.id.search)
    SearchView search;
    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    @BindView(R.id.recy_home)
    RecyclerView recyHome;
    BannerPresenter bannerPresenter;
    private List<CommodityList> list = new ArrayList<>();
    private LinearLayoutManager manager;
    private GoodsPresenter goodsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //实例化P层
        bannerPresenter = new BannerPresenter(this);
        bannerPresenter.onBannerPresenter();
        goodsPresenter = new GoodsPresenter(this);
        goodsPresenter.onGoodsPresenter();
        //跑马灯效果
        //设置跑马灯的数据
        List<String> info = new ArrayList<>();
        info.add("狼王：叶歉，狼牙雇佣军首领，铁血柔情，有着清晰的头脑和明确的目标！");
        info.add("野狼：李伟，追踪和反追踪高手！");
        info.add("詹姆斯　M国海豹部队退役少校");
        info.add("威廉　M国海豹部队退役士兵");
        info.add("雪狼：杰克，电脑天才，狼牙雇佣军军师");
        info.add("森林狼：峰l岚，丛林战专家");
        info.add("疾风狼：清风，性格张扬，精通枪械");
        info.add("毒狼：刘天尘，擅长用毒，狼牙雇佣军里御用卫生员");
        info.add("飞天狼：吴焕锋，独臂，擅长飞刀。");
        info.add("宋然，曾经暗夜百合的顶级杀手，虽掌管昊天集团，却也是狼牙的一份子。");
        // 在代码里设置自己的动画
        marqueeView.startWithList(info);
        // 在代码里设置自己的动画
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);
    }

    @OnClick(R.id.img_sys)
    public void onViewClicked() {
        startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            //处理扫描结果(在界面上显示)
            if (data != null) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

    @Override
    public void showGoodsSuccess(Root root) {
        Result result = root.getResult();
        List<CommodityList> pzsh = root.getResult().getPzsh().get(0).getCommodityList();

        List<CommodityList> mlss = root.getResult().getMlss().get(0).getCommodityList();

        List<CommodityList> rxxp = root.getResult().getRxxp().get(0).getCommodityList();


        list.addAll(mlss);
        list.addAll(pzsh);
        list.addAll(rxxp);
        //设置布局管理器
        manager = new LinearLayoutManager(this, LinearLayoutManager
                .VERTICAL, false);
        recyHome.setLayoutManager(manager);
        //设置适配器
        GoodsAdapters goodsAdapters = new GoodsAdapters(list);
        recyHome.setAdapter(goodsAdapters);


    }


    @Override
    public void showBanner(BannerEntity bannerEntity) {
        Toast.makeText(this, bannerEntity.getMessage(), Toast.LENGTH_SHORT).show();
        List<BannerEntity.ResultBean> beanList = bannerEntity.getResult();
        List<String> images = new ArrayList<>();
        for (int i = 0; i < beanList.size(); i++) {
            images.add(beanList.get(i).getImageUrl());
        }
        //设置banner样式
        homeBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        homeBanner.setImageLoader(new HomeImageLoader());
        //设置图片集合
        homeBanner.setImages(images);
        //设置自动轮播，默认为true
        homeBanner.isAutoPlay(true);
        //设置轮播时间
//        homeBanner.setDelayTime();
        //banner设置方法全部调用完毕时最后调用
        homeBanner.start();
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public Context CONTEXT() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bannerPresenter.onDestroy();
    }
}
