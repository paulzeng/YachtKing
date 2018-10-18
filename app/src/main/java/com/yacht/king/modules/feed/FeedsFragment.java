package com.yacht.king.modules.feed;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.brother.lib.base.BaseFragment;
import com.yacht.king.adapter.FeedsPageAdapter;
import com.yacht.king.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FeedsFragment extends BaseFragment {
    @BindView(R.id.mTb)
    TabLayout mTb;
    @BindView(R.id.mVp)
    ViewPager mVp;

    FeedsPageAdapter adapter;
    private List<BaseFragment> mFragmentList;
    private List<String> mTitleList;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_feed;
    }

    @Override
    protected void initView() {
        //添加标题
        initTitile();
        //添加fragment
        initFragment();
        //设置适配器
        mVp.setAdapter(new FeedsPageAdapter(this.getChildFragmentManager(), mFragmentList, mTitleList));
        //将tablayout与fragment关联
        mTb.setupWithViewPager(mVp);
        //设置可以滑动
        mTb.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initTitile() {
        mTitleList = new ArrayList<>();
        mTitleList.add("推荐");
        mTitleList.add("资讯");
        mTitleList.add("经销商");
        mTitleList.add("游艇俱乐部");
        mTitleList.add("游艇模特");
        mTitleList.add("游艇图库");
        //设置tablayout模式
        mTb.setTabMode(TabLayout.MODE_FIXED);
        //tablayout获取集合中的名称
        mTb.addTab(mTb.newTab().setText(mTitleList.get(0)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(1)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(2)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(3)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(4)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(5)));
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(FeedsListFragment.newInstance("第一个界面"));
        mFragmentList.add(FeedsListFragment.newInstance("第二个界面"));
        mFragmentList.add(FeedsListFragment.newInstance("第三个界面"));
        mFragmentList.add(FeedsListFragment.newInstance("第一个界面"));
        mFragmentList.add(FeedsListFragment.newInstance("第二个界面"));
        mFragmentList.add(FeedsListFragment.newInstance("第三个界面"));
    }
}
