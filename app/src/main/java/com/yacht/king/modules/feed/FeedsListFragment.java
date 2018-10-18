package com.yacht.king.modules.feed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.brother.lib.base.BaseFragment;
import com.brother.lib.utils.recylerviewadapter.MultiItemTypeAdapter;
import com.yacht.king.R;
import com.yacht.king.bean.FeedsBean;
import com.yacht.king.delegate.FeedImagesDelegate;
import com.yacht.king.delegate.FeedLargeDelegate;
import com.yacht.king.delegate.FeedSmallDelegate;
import com.yacht.king.delegate.FeedVideoDelegate;
import com.yacht.king.utils.DataControl;
import com.yacht.king.view.LoadMoreFooterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FeedsListFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener, MultiItemTypeAdapter.OnItemClickListener{
    @BindView(R.id.irv_feed)
    IRecyclerView contentRcv;
    private List<FeedsBean> mDatas;
    private MultiItemTypeAdapter multiItemTypeAdapter;
    private LoadMoreFooterView loadMoreFooterView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_feeds_list;
    }

    @Override
    protected void initView() {
        initListView();

    }
    public static FeedsListFragment newInstance(String tag){
        FeedsListFragment myFragment = new FeedsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", tag);
        //传递参数
        myFragment.setArguments(bundle);
        return myFragment;

    }
    private void initListView() {
        mDatas = DataControl.getFeeds();
        loadMoreFooterView = (LoadMoreFooterView) contentRcv.getLoadMoreFooterView();
        multiItemTypeAdapter = new MultiItemTypeAdapter(this.getContext(), mDatas);
        multiItemTypeAdapter.addItemViewDelegate(new FeedImagesDelegate(fa));
        multiItemTypeAdapter.addItemViewDelegate(new FeedLargeDelegate(fa));
        multiItemTypeAdapter.addItemViewDelegate(new FeedSmallDelegate(fa));
        multiItemTypeAdapter.addItemViewDelegate(new FeedVideoDelegate(fa));
        linearLayoutManager = new LinearLayoutManager(this.getContext());
        contentRcv.setLayoutManager(linearLayoutManager);
        contentRcv.setOnRefreshListener(this);
        contentRcv.setOnLoadMoreListener(this);
        contentRcv.setIAdapter(multiItemTypeAdapter);
        multiItemTypeAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取参数
        Bundle arguments = getArguments();
        //改变值
        //mTv.setText(arguments.getString("tag"));
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }
}
