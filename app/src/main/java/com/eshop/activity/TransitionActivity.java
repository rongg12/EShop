package com.eshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;

import com.eshop.R;

/**
 * 设置具有转场效果的基类
 * Created by Administrator on 2017/5/23.
 */

public class TransitionActivity extends AppCompatActivity {
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        // 设置转场效果
        setTransitionAnimator(true);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        //设置转场效果
        setTransitionAnimator(true);
    }

    @Override
    public void finish() {
        super.finish();
        //设置转场效果
        setTransitionAnimator(false);
    }

    /**
     * 不需要的时候，设置没有动画效果的
     */
    public void finishWithDefault(){
        super.finish();
    }

    /**
     * 设置跳转的动画
     * @param isNewActivity
     */
    public void setTransitionAnimator(boolean isNewActivity) {
        if (isNewActivity){
            //新的页面从右边进入
            overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
        }else{
            //回到上个页面
            overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
        }
    }
}
