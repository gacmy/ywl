package com.gac.ywl.utils;


import android.content.Context;

import com.gac.ywl.R;


/**
 * @title Constants.java
 * @package com.gac.footprint.base.model
 * @description  {固定的常量操作}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public class Constants {
    public static Context sContext;
    public static String[] ARRAY_LOGIN_CHECK;

    public static void init(Context context){
        sContext = context;
        ARRAY_LOGIN_CHECK = sContext.getResources().getStringArray(R.array.checklogin);
    }

    public static String[] getLoginCheck(){
        return ARRAY_LOGIN_CHECK;
    }
}
