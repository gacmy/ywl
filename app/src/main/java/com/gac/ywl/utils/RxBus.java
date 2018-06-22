package com.gac.ywl.utils;

/**
 * Created by gacmy on 2018/6/14 0014.
 */

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * @author gac
 */
public class RxBus {

    private final Subject<Object> mBus;
    Disposable mDisposable;
    private RxBus() {
        // toSerialized method made bus thread safe
        mBus = PublishSubject.create().toSerialized();
    }

    public static RxBus get() {
        return Holder.BUS;
    }

    public void post(Object obj) {
        mBus.onNext(obj);
    }

    public void subscribeEvent(Consumer<Object> consumer){
        mDisposable = toObservable().subscribe(consumer);
    }

    public void unregisterEvent(){
        if(mDisposable != null){
            mDisposable.dispose();
        }
    }
    /**
     * 注册事件
     * @param tClass
     * @param <T>
     * @return
     */
    public   <T> Observable<T> toObservable(Class<T> tClass) {
//        Observable observable;
//        observable.subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//
//            }
//        })
        return mBus.ofType(tClass);
    }

    public Observable<Object> toObservable() {
        return mBus;
    }

    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    private static class Holder {
        private static final RxBus BUS = new RxBus();
    }
}