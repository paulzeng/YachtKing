package com.yacht.king;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.brother.lib.base.BaseActivity;
import com.yacht.king.modules.circle.CircleFragment;
import com.yacht.king.modules.feed.FeedsFragment;
import com.yacht.king.modules.my.MyFragment;
import com.yacht.king.modules.video.VideoFragment;
import com.yacht.king.modules.yacht.YachtFragment;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

public class MainActivity extends BaseActivity {

    @BindView(R.id.container_fly)
    FrameLayout containerFly;
    @BindView(R.id.home_rbtn)
    RadioButton homeRbtn;
    @BindView(R.id.inbox_rbtn)
    RadioButton inboxRbtn;
    @BindView(R.id.discover_rbtn)
    RadioButton discoverRbtn;
    @BindView(R.id.notify_rbtn)
    RadioButton notifyRbtn;
    @BindView(R.id.my_rbtn)
    RadioButton myRbtn;
    @BindView(R.id.main_rdg)
    RadioGroup mainRdg;

    private FeedsFragment mFeedsFragment;
    private VideoFragment mVideoFragment;
    private YachtFragment mYachtFragment;
    private CircleFragment mCircleFragment;
    private MyFragment mMyFragment;

    //防止activity销毁，Fragment部分重影问题
    @Override
    public void onAttachFragment(Fragment fragment) {
        //super.onAttachFragment(fragment);
        if(mFeedsFragment == null & fragment instanceof FeedsFragment){
            mFeedsFragment = (FeedsFragment)fragment;
        }else if(mVideoFragment == null && fragment instanceof VideoFragment){
            mVideoFragment = (VideoFragment)fragment;
        }else if(mYachtFragment == null && fragment instanceof  YachtFragment){
            mYachtFragment = (YachtFragment)fragment;
        }else if(mCircleFragment == null && fragment instanceof CircleFragment){
            mCircleFragment = (CircleFragment)fragment;
        }else if(mMyFragment == null && fragment instanceof MyFragment){
            mMyFragment = (MyFragment)fragment;
        }
    }

    private void hideAllFragments(FragmentTransaction transaction) {
        if (mFeedsFragment != null) {
            transaction.hide(mFeedsFragment);
        }
        if (mVideoFragment != null) {
            transaction.hide(mVideoFragment);
        }
        if (mYachtFragment != null) {
            transaction.hide(mYachtFragment);
        }
        if (mCircleFragment != null) {
            transaction.hide(mCircleFragment);
        }
        if (mMyFragment != null) {
            transaction.hide(mMyFragment);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initFragments();
    }

    private void initFragments() {
        homeRbtn.setChecked(true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragments(transaction);

        if (mFeedsFragment == null) {
            mFeedsFragment = new FeedsFragment();
            transaction.add(R.id.container_fly, mFeedsFragment);
        } else {
            transaction.show(mFeedsFragment);
        }

        transaction.commitAllowingStateLoss();
    }

    @OnCheckedChanged({R.id.home_rbtn, R.id.inbox_rbtn, R.id.discover_rbtn, R.id.notify_rbtn, R.id.my_rbtn})
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragments(transaction);
        switch (compoundButton.getId()) {
            case R.id.home_rbtn: {
                if (compoundButton.isChecked()) {
                    if (mFeedsFragment == null) {
                        mFeedsFragment = new FeedsFragment();
                        transaction.add(R.id.container_fly, mFeedsFragment);
                    } else {
                        transaction.show(mFeedsFragment);
                    }
                    transaction.commitAllowingStateLoss();
                }
            }
            break;
            case R.id.inbox_rbtn: {
                if (compoundButton.isChecked()) {
                    if (mVideoFragment == null) {
                        mVideoFragment = new VideoFragment();
                        transaction.add(R.id.container_fly, mVideoFragment);
                    } else {
                        transaction.show(mVideoFragment);
                    }
                    transaction.commitAllowingStateLoss();
                }
            }
            break;
            case R.id.discover_rbtn: {
                if (compoundButton.isChecked()) {
                    if (mYachtFragment == null) {
                        mYachtFragment = new YachtFragment();
                        transaction.add(R.id.container_fly, mYachtFragment);
                    } else {
                        transaction.show(mYachtFragment);
                    }
                    transaction.commitAllowingStateLoss();
                }
            }
            break;
            case R.id.notify_rbtn: {
                if (compoundButton.isChecked()) {
                    if (mCircleFragment == null) {
                        mCircleFragment = new CircleFragment();
                        transaction.add(R.id.container_fly, mCircleFragment);
                    } else {
                        transaction.show(mCircleFragment);
                    }
                    transaction.commitAllowingStateLoss();
                }
            }
            break;
            case R.id.my_rbtn: {
                if (compoundButton.isChecked()) {
                    if (mMyFragment == null) {
                        mMyFragment = new MyFragment();
                        transaction.add(R.id.container_fly, mMyFragment);
                    } else {
                        transaction.show(mMyFragment);
                    }
                    transaction.commitAllowingStateLoss();
                }
            }
            break;
        }
    }
}
