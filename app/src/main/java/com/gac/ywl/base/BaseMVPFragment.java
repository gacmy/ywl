package com.gac.ywl.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @title BaseMVPFragment.java
 * @package com.gac.footprint.base.base
 * @description  {}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public abstract class BaseMVPFragment<T extends BasePresenter,K extends BaseView> extends BaseFragment{
    T mPresenter;
    K mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initMVP();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initMVP(){
        initBaseView(mView);
        initPresenter(mPresenter);
        mPresenter.attach(mView);
        getLifecycle().addObserver(mPresenter);
    }
    /**
     * 初始化
     * @param view
     */
    protected abstract void initBaseView(IView view);

    protected abstract void initPresenter(IPresenter presenter);

    @Override
    public void onDetach() {
        super.onDetach();
        if(mPresenter != null){
            getLifecycle().removeObserver(mPresenter);

        }
    }
}
