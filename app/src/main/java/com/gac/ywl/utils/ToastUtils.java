package com.gac.ywl.utils;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gac.ywl.R;


/**
 * @title ToastUtils.java
 * @package com.gac.footprint.base.utils
 * @description  {}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public class ToastUtils {

    private static volatile ToastUtils instance;

    public static ToastUtils getInstance(){
        if(instance==null){
            synchronized (ToastUtils.class){
                if(instance==null){
                    instance = new ToastUtils();
                }
            }
        }
        return instance;
    }


    private Toast mToast;
    View toastView = null;
    TextView toast_text;
    public void showToast(String text){
        if(mToast == null){
            mToast = new Toast(Constants.sContext);
        }
        if(toastView==null){
            toastView = View.inflate(Constants.sContext, R.layout.toast_topview,null);
            toast_text = (TextView)toastView.findViewById(R.id.toast_text);
            toast_text.setLayoutParams(new LinearLayout.LayoutParams(DensityUtil.getScreenWidth(), ViewGroup.LayoutParams.WRAP_CONTENT));
            mToast.setView(toastView);
            mToast.setGravity(Gravity.TOP,0,0);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        toast_text.setText(text);
        mToast.show();
    }

}
