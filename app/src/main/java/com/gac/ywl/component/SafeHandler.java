package com.gac.ywl.component;


import android.app.Activity;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * @title SafeHandler.java
 * @package com.gac.footprint.base.component
 * @description  {判断activity是否退出}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public class SafeHandler extends android.os.Handler {
    WeakReference<Activity> activityWeakReference;
    public boolean canRun = true;

    public SafeHandler(Activity activity){
        activityWeakReference = new WeakReference<Activity>(activity);
        canRun = true;
    }
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        final Activity activity = activityWeakReference.get();
        if(activity==null||activity.isFinishing()){
            canRun = false;
            return;
        }
    }
}
