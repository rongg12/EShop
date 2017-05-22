package com.eshop.utils;


import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 单例模式
 *     网络核心类
 * Created by Administrator on 2017/5/22.
 */

public class EShopClient {

    private final OkHttpClient mOkHttpClient;
    private static EShopClient mEShopClient;

    private EShopClient() {
        //日志拦截器的创建
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OKHttpClient的初始化
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
    }
    public static synchronized EShopClient getInstance(){
        if (mEShopClient==null){
            mEShopClient=new EShopClient();
        }
        return mEShopClient;
    }
    //创建商品分类的接口请求
    public Call getCategory(){
        Request request=new Request.Builder().get()
                .url(Costants.CATEGORY_URL).build();
        return mOkHttpClient.newCall(request);
    }
}
