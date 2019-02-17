package com.songyang.small.homework_two.base;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver implements Observer<String> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(String s) {
        onSuccess(s);
    }

    @Override
    public void onError(Throwable e) {
        onFailed(e);
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(String s);

    public abstract void onFailed(Throwable e);
}
