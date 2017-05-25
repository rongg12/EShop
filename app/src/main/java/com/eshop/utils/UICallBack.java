package com.eshop.utils;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 封装的UICallBack,
 *    使OkHttpClient返回的数据，
 *        原本在后台运行的转化为在主线程运行
 *
 * Created by Administrator on 2017/5/22.
 */

public abstract class UICallBack implements Callback {
    /**
     * 创建一个运行在主线程的Handler
     *    通过构造方法传入主线程的Looper
     */
    private Handler mHandler=new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //运行在主线程，可以更新UI了
                onFailureInUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //运行在主线程，可以更新UI了
                onResponseInUI(call,response);
            }
        });
    }
    /**
     * 要让调用者，必须实现两个方法，分别处理请求失败和成功
     *    定义两个抽象方法，分别处理请求失败和成功
     */
    public abstract void onFailureInUI(Call call, IOException e);
    public abstract void onResponseInUI(Call call, Response response);

}
