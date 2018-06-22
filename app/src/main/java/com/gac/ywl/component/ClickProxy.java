package com.gac.ywl.component;

import android.view.View;

/**
 * @title ClickProxy.java
 * @package com.gac.footprint.base.component
 * @description  {代理监听click点击事件}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public class ClickProxy implements View.OnClickListener {
    private View.OnClickListener origin;
    private AgainClickListener mAgainClickListener;
    private long lastclick = 0;
    private long timems = 1000;

    /**
     * 不需要重复点击事件
     * @param origin
     */
    public ClickProxy(View.OnClickListener origin) {
        this.origin = origin;
    }

    /**
     * 需要重复点击事件
     * @param origin
     * @param againlistenr
     */
    public ClickProxy(View.OnClickListener origin,AgainClickListener againlistenr){
        this.origin = origin;
        this.mAgainClickListener = againlistenr;
    }
    @Override
    public void onClick(View v) {
        if (System.currentTimeMillis() - lastclick >= timems) {
            origin.onClick(v);
            lastclick = System.currentTimeMillis();
        }else{
            if(mAgainClickListener != null){
                mAgainClickListener.againClick(v);
            }
        }
    }


}