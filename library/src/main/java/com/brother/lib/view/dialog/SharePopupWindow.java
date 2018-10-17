package com.brother.lib.view.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.brother.lib.R;
import com.brother.lib.base.BaseApplication;
import com.brother.lib.utils.WechatShareManager;


/**
 * Created by 刘晓彬 on 2017/4/8.
 */

public class SharePopupWindow extends PopupWindow implements View.OnClickListener {

    private View mContentView;
    private View mShareWeichatFriends;
    private View mShareWeichat;
    private View mShareQQ;
    private View mShareWeibo;
    private View mShareUrl;
    private String title, content, image_url, target_url;

    private String type = "default";

    public SharePopupWindow(View contentView) {
        super(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView = contentView;
        mShareWeichatFriends = mContentView.findViewById(R.id.iv_share_friends);
        mShareWeichat = mContentView.findViewById(R.id.iv_share_weichat);
        mShareQQ = mContentView.findViewById(R.id.iv_share_qq);
        mShareWeibo = mContentView.findViewById(R.id.iv_share_weibo);
        mShareUrl = mContentView.findViewById(R.id.iv_share_url);

        mShareWeichatFriends.setOnClickListener(this);
        mShareWeichat.setOnClickListener(this);
        mShareQQ.setOnClickListener(this);
        mShareWeibo.setOnClickListener(this);
        mShareUrl.setOnClickListener(this);
        mContentView.setOnClickListener(this);


        this.setAnimationStyle(R.style.PopupWindowAnimationBottom);
    }

    public SharePopupWindow(View contentView, String type) {
        super(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView = contentView;
        mShareWeichatFriends = mContentView.findViewById(R.id.iv_share_friends);
        mShareWeichat = mContentView.findViewById(R.id.iv_share_weichat);
        mShareQQ = mContentView.findViewById(R.id.iv_share_qq);
        mShareWeibo = mContentView.findViewById(R.id.iv_share_weibo);
        mShareUrl = mContentView.findViewById(R.id.iv_share_url);

        mShareWeichatFriends.setOnClickListener(this);
        mShareWeichat.setOnClickListener(this);
        mShareQQ.setOnClickListener(this);
        mShareWeibo.setOnClickListener(this);
        mShareUrl.setOnClickListener(this);
        mContentView.setOnClickListener(this);
        this.type = type;


        this.setAnimationStyle(R.style.PopupWindowAnimationBottom);
    }

    public SharePopupWindow(View contentView, String title, String content, String image_url, String target_url) {
        super(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.title = title;
        this.content = content;
        this.image_url = image_url;
        this.target_url = target_url;
        mContentView = contentView;
        mShareWeichatFriends = mContentView.findViewById(R.id.iv_share_friends);
        mShareWeichat = mContentView.findViewById(R.id.iv_share_weichat);
        mShareQQ = mContentView.findViewById(R.id.iv_share_qq);
        mShareWeibo = mContentView.findViewById(R.id.iv_share_weibo);
        mShareUrl = mContentView.findViewById(R.id.iv_share_url);

        mShareWeichatFriends.setOnClickListener(this);
        mShareWeichat.setOnClickListener(this);
        mShareQQ.setOnClickListener(this);
        mShareWeibo.setOnClickListener(this);
        mShareUrl.setOnClickListener(this);
        mContentView.setOnClickListener(this);

        this.setAnimationStyle(R.style.PopupWindowAnimationBottom);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.iv_share_friends){
            if(type.equals("default")){
                WechatShareManager manager = WechatShareManager.getInstance(BaseApplication.getContext());
                WechatShareManager.ShareContentWebpage mShareContent  =  manager.new ShareContentWebpage(title,content,target_url,image_url);
                //BaseApplication.showToast("分享朋友圈");
                WechatShareManager.getInstance(BaseApplication.getContext()).shareByWebchat(mShareContent, WechatShareManager.WECHAT_SHARE_TYPE_FRENDS);
            }else{
                WechatShareManager manager = WechatShareManager.getInstance(BaseApplication.getContext());
                WechatShareManager.ShareContentPicture mShareContentPicture = (WechatShareManager.ShareContentPicture) manager.getShareContentPicture("https://b-ssl.duitang.com/uploads/item/201808/09/20180809180128_mMeSV.thumb.400_400_c.png");
                manager.shareByWebchat(mShareContentPicture, WechatShareManager.WECHAT_SHARE_TYPE_FRENDS);
            }
        }else if(view.getId()==R.id.iv_share_weichat){
            if(type.equals("default")) {
                WechatShareManager manager2 = WechatShareManager.getInstance(BaseApplication.getContext());
                WechatShareManager.ShareContentWebpage mShareContent2 = manager2.new ShareContentWebpage(title, content, target_url, image_url);
                //BaseApplication.showToast("分享好友");
                WechatShareManager.getInstance(BaseApplication.getContext()).shareByWebchat(mShareContent2, WechatShareManager.WECHAT_SHARE_TYPE_TALK);
            }else{
                WechatShareManager manager = WechatShareManager.getInstance(BaseApplication.getContext());
                WechatShareManager.ShareContentPicture mShareContentPicture = (WechatShareManager.ShareContentPicture) manager.getShareContentPicture("https://b-ssl.duitang.com/uploads/item/201808/09/20180809180128_mMeSV.thumb.400_400_c.png");
                manager.shareByWebchat(mShareContentPicture, WechatShareManager.WECHAT_SHARE_TYPE_TALK);
            }
        }
        dismiss();
    }


}
