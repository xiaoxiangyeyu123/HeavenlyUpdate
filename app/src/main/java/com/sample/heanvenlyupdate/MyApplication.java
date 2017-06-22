package com.sample.heanvenlyupdate;

import android.app.Application;

import org.xutils.x;

/**
 * Created by hasee on 2017/6/17.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
