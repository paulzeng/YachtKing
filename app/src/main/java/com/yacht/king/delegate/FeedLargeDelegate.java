package com.yacht.king.delegate;

import com.brother.lib.base.BaseActivity;
import com.brother.lib.utils.recylerviewadapter.base.ItemViewDelegate;
import com.brother.lib.utils.recylerviewadapter.base.ViewHolder;
import com.yacht.king.R;
import com.yacht.king.bean.FeedsBean;
import com.yacht.king.utils.Constants;

public class FeedLargeDelegate implements ItemViewDelegate<FeedsBean> {
    private BaseActivity mActivity;

    public FeedLargeDelegate(BaseActivity activity) {
        this.mActivity = activity;
    }
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_feed_large;
    }

    @Override
    public boolean isForViewType(FeedsBean item, int position) {
        return item.getType().equals(Constants.FEED_LARGE);
    }

    @Override
    public void convert(ViewHolder holder, FeedsBean feedsBean, int position) {

    }
}
