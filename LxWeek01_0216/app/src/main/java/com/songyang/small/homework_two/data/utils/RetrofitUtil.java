package com.songyang.small.homework_two.data.utils;

import com.songyang.small.homework_two.data.Constant.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {
    //提供一个本地工具类引用
    private static RetrofitUtil retrofitUtil;
    private final HttpLoggingInterceptor interceptor;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    //私有化构造器
    private RetrofitUtil() {
        //添加拦截器
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OkHttpClient
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
//                .readTimeout(5000, TimeUnit.MICROSECONDS)
//                .writeTimeout(5000, TimeUnit.MICROSECONDS)
//                .connectTimeout(5000, TimeUnit.MICROSECONDS)
//                .connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
                .build();
        //retrofit
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constant.ORDER_PATH)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    //公有化构造器:供外部类访问
    public static RetrofitUtil getRetrofitUtil() {
        //DCL模式 :懒汉式
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {//线程锁---保证获取对象唯一
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }



    public <T> T create(Class<T> service)   {
        return retrofit.create(service);
    }
}
