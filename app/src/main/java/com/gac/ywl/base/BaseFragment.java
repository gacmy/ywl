package com.gac.ywl.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gac.ywl.utils.RxBus;


/**
 * @title BaseFragment.java
 * @package com.gac.footprint.base.base
 * @description  {}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public abstract class BaseFragment extends Fragment {
    protected boolean isPrepared;
    protected boolean isLoadedOnce;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        isPrepared = true;
        // 数据加载
        loadData();
        subscribeEvent();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }
    protected void initView(){

    }
    protected abstract int getLayoutId() ;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        loadData();
    }

    protected void loadData() {
        if(!isPrepared || !getUserVisibleHint() || isLoadedOnce)
            return;
        // 懒加载
        lazyLoad();
        isLoadedOnce = true;
    }

    protected abstract void lazyLoad();

    @Override
    public void onDetach() {
        super.onDetach();
        RxBus.get().unregisterEvent();
        isPrepared = isLoadedOnce = false;
    }
    /**
     * 注册事件
     */
    protected void subscribeEvent(){
        //RxBus.get().toObservable().

    }

}
