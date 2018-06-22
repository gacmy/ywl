package com.gac.ywl.base;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;


public interface IPresenter extends LifecycleObserver{

    public void attach(IView view);

    public void detach();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate( LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy( LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onLifecycleChanged( LifecycleOwner owner,
                             Lifecycle.Event event);



    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume( LifecycleOwner owner);
}
