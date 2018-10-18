package com.yacht.king.delegate;

import com.brother.lib.base.BaseActivity;
import com.brother.lib.utils.recylerviewadapter.base.ItemViewDelegate;
import com.brother.lib.utils.recylerviewadapter.base.ViewHolder;
import com.yacht.king.R;
import com.yacht.king.bean.FeedsBean;
import com.yacht.king.utils.Constants;

public class FeedSmallDelegate implements ItemViewDelegate<FeedsBean> {
    private BaseActivity mActivity;

    public FeedSmallDelegate(BaseActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_feed_small;
    }

    @Override
    public boolean isForViewType(FeedsBean item, int position) {
        return item.getType().equals(Constants.FEED_SMALL);
    }

    @Override
    public void convert(ViewHolder holder, FeedsBean feedsBean, int position) {

    }
}
