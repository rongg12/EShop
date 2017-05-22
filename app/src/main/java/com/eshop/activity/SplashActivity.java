package com.eshop.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.eshop.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  Splash 页面：图片播放2秒的渐变动画(透明度变化)之后，跳转到主页面
 */
public class SplashActivity extends AppCompatActivity implements Animator.AnimatorListener {
    @BindView(R.id.image_splash)
    ImageView mIvSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化
     */
    public void initView(){
        /**
         * 属性动画:ViewPropertyAnimator：针对于View进行操作的动画类
         *    1.针对View进行操作：通过View调用
         *    2.简洁的链式调用，调用多个动画效果，动画同时进行
         *    3.多个动画属性同时进行，UI只刷新一次，性能上更加优化
         *    4.使用：View调用animate()方法拿到引用
         */
        //首先，设置一个透明度
        mIvSplash.setAlpha(0.3f);
        mIvSplash.animate()
                 .alpha(1.0f)     //设置透明度的变化
                 .setDuration(2000)  //设置动画持续事件
                 .setListener(this)  //设置动画的监听
                 .start();    //开始动画
    }

    /**
     * 动画开始的时候触发
     * @param animation
     */
    @Override
    public void onAnimationStart(Animator animation) {

    }
    /**
     * 动画结束的时候触发
     * @param animation
     */
    @Override
    public void onAnimationEnd(Animator animation) {
        Intent intent=new Intent(this,EShopMainActivity.class);
        startActivity(intent);
        //设置动画转场效果，直接在里面放置动画资源
        overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
        finish();
    }
    /**
     * 动画取消的时候
     * @param animation
     */
    @Override
    public void onAnimationCancel(Animator animation) {

    }

    /**
     * 动画重复播放的时候
     * @param animation
     */
    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
