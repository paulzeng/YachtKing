package com.yacht.king.modules.yacht;

import com.brother.lib.base.BaseFragment;
import com.brother.lib.view.AppToolbar;
import com.yacht.king.R;

import butterknife.BindView;

public class YachtFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    AppToolbar mToolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_yacht;
    }

    @Override
    protected void initView() {
        mToolbar.setToolbarTitle("游艇");
    }
}
