package com.tm.blplayer.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author wutongming
 * @description
 * @since 2017/5/17
 */

public class ToastUtils {


    public static void showToast(Context context, String text) {
        showShortToast(context, text);
    }

    public static void showToast(Context context, int strId) {
        showShortToast(context, strId);
    }

    public static void showShortToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showShortToast(Context context, int strId) {
        showShortToast(context, context.getResources().getString(strId));
    }

    public static void showLongToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void showLongToast(Context context, int strId) {
        showShortToast(context, context.getResources().getString(strId));
    }

}
