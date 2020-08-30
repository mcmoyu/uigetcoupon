package com.moyu.uigetcoupon;

import android.content.Context;
import android.widget.Toast;

public class Debug {

    private Context context;

    public Debug(Context context) {
        this.context = context;
    }

    public void setToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param msg 内容
     * @param duration 0:short,1:long
     */
    public void setToast(String msg, int duration) {
        Toast.makeText(context, msg, duration).show();
    }

    public void setPrint(String msg) {
        System.out.print(msg);
    }

    public void setPrint(String msg, boolean isLn) {
        if(isLn) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }

}
