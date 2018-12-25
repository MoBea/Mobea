package com.wbapp.mobea.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * @author  Barruizhi
 * @date    2018/4/8
 * @body    工具包
 */
public class Dlog {
    //信息弹窗
    public static void msgBox(Context context, String msg)
    {
        try {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);
            dlgAlert.setMessage(msg);
            dlgAlert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                     dialog.cancel();
                }
            });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        } catch (Exception ex) {
            // sometimes we run into this if the activity
            // is destroyed. it doesn't matter so much.
            ex.printStackTrace();
        }
    }
}
