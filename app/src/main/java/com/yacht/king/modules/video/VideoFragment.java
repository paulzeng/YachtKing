package com.yacht.king.modules.video;

import com.brother.lib.base.BaseFragment;
import com.brother.lib.view.AppToolbar;
import com.yacht.king.R;

import butterknife.BindView;

public class VideoFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    AppToolbar mToolbar;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        mToolbar.setToolbarTitle("视频");
    }
}
