package com.yacht.king.utils;

import com.yacht.king.bean.FeedsBean;

import java.util.ArrayList;
import java.util.List;

public class DataControl {
    public static List<FeedsBean> getFeeds(){
        List<FeedsBean> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            if(i%2==0){
                FeedsBean bean = new FeedsBean();
                bean.setType(Constants.FEED_SMALL);
                list.add(bean);
            }else{
                FeedsBean bean = new FeedsBean();
                bean.setType(Constants.FEED_LARGE);
                list.add(bean);
            }

        }
        return list;
    }
}
