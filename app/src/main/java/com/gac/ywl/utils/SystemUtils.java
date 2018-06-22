package com.gac.ywl.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * @描述：
 * @file_name：com.gac.ywl.utils
 * @author：gac
 * @time：2018/6/22:15:07
 */

public class SystemUtils {
    /**
     * 复制链接
     */
    public static void copyText(String text) {
        ClipboardManager cm = (ClipboardManager) Constants.sContext.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData myClip = ClipData.newPlainText("text",text);
        cm.setPrimaryClip(myClip);
//		cm.getPrimaryClip().addItem(new ClipData.Item(mLastLoadUrl));
        ToastUtils.getInstance().showToast("已复制到剪贴板");
    }
}
