package com.brother.lib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    //根视图
    protected View rootView;
    //视图绑定
    private Unbinder mUnbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    //获取布局文件
    protected abstract int getLayoutResource();

    //初始化view
    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
