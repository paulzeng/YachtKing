package com.brother.lib.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.brother.lib.R;
import com.brother.lib.utils.StatusBarSetting;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        setContentView(getLayoutId());
        setStatusBarColor();
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    private void doBeforeSetContentView(){
        // 把actvity放到application栈中管理
        ActivityManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public abstract int getLayoutId();

    protected void setStatusBarColor(){
        StatusBarSetting.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

    public abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        ActivityManager.getAppManager().finishActivity(this);
    }
}
