package com.gac.ywl.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import java.util.Stack;

/**
 * @title ActivityUtils.java
 * @package com.gac.footprint.base.utils
 * @description  {activity 管理}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */

public class ActivityUtils {
    private static final String TAG_LOGACTIVITY="com.hpkj.yzfm.module.loginmodule.activity.LoginActivity";
    private static final String TAG_REGISTERACTRIVITY="com.hpkj.yzfm.module.loginmodule.activity.RegisterActivity";
    private static final String TAG_SETPAWDACTIVITY="com.hpkj.yzfm.module.loginmodule.activity.SetPawdActivity";
    private static final String TAG_EDITPERSONALACTIVITY="com.hpkj.yzfm.module.loginmodule.activity.EditPersonalActivity";

    private static ActivityUtils activityManager;
    private static Stack<Activity> activityList = new Stack<Activity>();

    public static ActivityUtils getInstance() {
        if (activityManager == null) {
            activityManager = new ActivityUtils();
        }
        return activityManager;
    }

    public ActivityUtils() {
        super();
    }

    /**
     * 把当前Activity放入栈中
     *
     * @param activity
     */
    public void pushActivity(Activity activity) {
        activityList.push(activity);
    }

    /**
     * 把所有Activity移除
     */
    public void popAllActivity() {
        while (!activityList.isEmpty()) {
            popActivity(activityList.pop());
        }
    }

    /**
     * 把当前Activity移除
     *
     * @param activity
     */
    public void popActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activityList.remove(activity);
            activity = null;
        }
    }

    /**
     * 重启应用
     */
    @SuppressLint("NewApi")
    public void resetApp(Activity activity) {
        while (!activityList.isEmpty()) {
            popActivity(activityList.pop());
        }
        Intent i = activity
                .getBaseContext()
                .getPackageManager()
                .getLaunchIntentForPackage(
                        activity.getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(i);
    }

    public int sizeOfActivitys(){
        if(Util.isNotEmpty(activityList)){
            for (int i=0;i<activityList.size();i++){
                Log.i("jj","ActivityUtils "+i+" :"+activityList.get(i).toString());
            }
        }
        return Util.isEmpty(activityList)?0:activityList.size();
    }

    /**
     * 退出系统
     */
    public void exit() {
        while (!activityList.isEmpty()) {
            popActivity(activityList.pop());
        }
        System.exit(0);
        Process.killProcess(Process.myPid());
    }

    /**
     * 把注册流程Activity移除
     */
    public void popRegisterActivity() {
        while (!activityList.isEmpty()) {
            Activity activity=activityList.pop();
            String className=activity.getComponentName().getClassName();
            if(TAG_LOGACTIVITY.equalsIgnoreCase(className)) {
                popActivity(activity);
            }
            else if(TAG_REGISTERACTRIVITY.equalsIgnoreCase(className)) {
                popActivity(activity);
            }
            else if(TAG_SETPAWDACTIVITY.equalsIgnoreCase(className)) {
                popActivity(activity);
            }
            else if(TAG_EDITPERSONALACTIVITY.equalsIgnoreCase(className)) {
                popActivity(activity);
            }
        }
    }

    /**
     * 跳转验证登录权限 权限配置本地文件
     * @param context
     * @param cls
     * @param login
     */
    public void startActivity(Context context,Class cls,Class login){
        String[] checks = Constants.getLoginCheck();
        if(Util.isEmpty(checks)){
            context.startActivity(new Intent(context,cls));
        }else{
            for (String check : checks) {
                if(check.equals(cls.getCanonicalName())){
                    context.startActivity(new Intent(context,login));
                    return;
                }
            }
            context.startActivity(new Intent(context,cls));

        }

    }
}