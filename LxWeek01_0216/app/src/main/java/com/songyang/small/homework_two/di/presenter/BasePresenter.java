package com.songyang.small.homework_two.di.presenter;


import com.songyang.small.homework_two.di.core.IView;

import java.lang.ref.SoftReference;

public abstract class BasePresenter<V extends IView> {
    protected V view;
    private final SoftReference<V> vSoftReference;

    /**
     * 绑定View
     */
    public BasePresenter(V view) {
        //软引用包裹
        vSoftReference = new SoftReference<>(view);
        this.view = view;
        initModel();
    }

    protected abstract void initModel();
    /**
     * 默认在view销毁的时候调用,解除绑定
     *在view销毁前释放presenter中的对象,资源.
     */
    public void onDestroy() {
        vSoftReference.clear();
        view = null;  //减少内存溢出时调用
    }



}
