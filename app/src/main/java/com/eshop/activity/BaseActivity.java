package com.eshop.activity;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 通用Activity的基类
 * Created by Administrator on 2017/5/23.
 */

public abstract class BaseActivity extends TransitionActivity{

    private Unbinder mUnbinder;
    //重复的视图绑定，解绑等
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置视图，需要子类告诉我们
        setContentView(getContentViewLayout());
        mUnbinder = ButterKnife.bind(this);
        //调用一个initView，让子类必须重写，在initView里面处理视图
        initView();
    }

    protected abstract void initView();
    //让子类告诉我们视图
    @LayoutRes
    protected abstract int getContentViewLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mUnbinder=null;
    }
}
