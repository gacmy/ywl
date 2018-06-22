package com.gac.ywl.base;


import android.arch.lifecycle.LifecycleOwner;


public abstract class BasePresenter implements IPresenter {
    IView root;
    @Override
    public void attach(IView view) {
        root = view;
    }

    @Override
    public void detach() {
        root = null;
    }



    @Override
    public void onDestroy( LifecycleOwner owner) {
        detach();
    }


}
