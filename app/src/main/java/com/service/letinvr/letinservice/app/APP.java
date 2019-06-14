package com.service.letinvr.letinservice.app;

import android.app.Application;
import android.content.Context;

import com.service.letinvr.letinservice.api.Constant;
import com.service.letinvr.letinservice.base.BaseActivity;

/**
 * 站在顶峰,看世界
 * 跌落谷底,思人生
 * 大姨夫 2018\10\20 0020
 **/
public class APP extends Application {

    public static Context context;

    public static BaseActivity activity;

    @Override
    public void onCreate() {
        super.onCreate();
        context =getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
