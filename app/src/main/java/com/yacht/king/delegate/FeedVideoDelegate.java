package com.yacht.king.delegate;

import com.brother.lib.base.BaseActivity;
import com.brother.lib.utils.recylerviewadapter.base.ItemViewDelegate;
import com.brother.lib.utils.recylerviewadapter.base.ViewHolder;
import com.yacht.king.R;
import com.yacht.king.bean.FeedsBean;

public class FeedVideoDelegate implements ItemViewDelegate<FeedsBean> {
    private BaseActivity mActivity;

    public FeedVideoDelegate(BaseActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_feed_video;
    }

    @Override
    public boolean isForViewType(FeedsBean item, int position) {
        return false;
    }

    @Override
    public void convert(ViewHolder holder, FeedsBean feedsBean, int position) {

    }
}
