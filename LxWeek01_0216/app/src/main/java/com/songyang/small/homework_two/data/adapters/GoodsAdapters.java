package com.songyang.small.homework_two.data.adapters;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.songyang.small.homework_two.R;
import com.songyang.small.homework_two.data.entity.CommodityList;

import java.util.List;

public class GoodsAdapters extends BaseMultiItemQuickAdapter<CommodityList, BaseViewHolder> {


    private String images;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public GoodsAdapters(List<CommodityList> data) {
        super(data);
        addItemType(CommodityList.TEXT, R.layout.item_one_layout);
        addItemType(CommodityList.IMG, R.layout.item_two_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityList item) {
        switch (helper.getItemViewType()) {
            case 0:
                helper.setText(R.id.tv_one, item.getCommodityName().toString());
                //图片
                images = item.getMasterPic();
                //控件获取
                SimpleDraweeView sdvicon = helper.getView(R.id.img_one);
                if (images != null) {
                    //加载显示时的进度条
                    sdvicon.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
                    //管理器
                    DraweeController controller = Fresco.newDraweeControllerBuilder()
                            //图片uri地址
                            .setUri(images)
                            //支持gif动图
                            .setAutoPlayAnimations(true)
                            .build();
                    //设置图片
                    sdvicon.setController(controller);
                }
                break;
            case 1:
                helper.setText(R.id.tv_two, item.getCommodityName().toString());
                //图片
                //控件获取
                SimpleDraweeView sdvicon1 = helper.getView(R.id.img_two);
                if (images != null) {
                    //加载显示时的进度条
                    sdvicon1.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
                    //管理器
                    DraweeController controller = Fresco.newDraweeControllerBuilder()
                            //图片uri地址
                            .setUri(images)
                            //支持gif动图
                            .setAutoPlayAnimations(true)
                            .build();
                    //设置图片
                    sdvicon1.setController(controller);
                }
                break;
        }
    }
}
