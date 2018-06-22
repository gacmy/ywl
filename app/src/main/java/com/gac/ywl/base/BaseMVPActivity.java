package com.gac.ywl.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseMVPActivity<T extends BasePresenter,K extends BaseView> extends BaseActivity{
   T mPresenter;
   K mView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMVP();

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
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            getLifecycle().removeObserver(mPresenter);

        }
    }
}
