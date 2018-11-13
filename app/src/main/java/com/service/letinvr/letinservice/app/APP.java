package com.service.letinvr.letinservice.app;

import android.app.Application;
import android.content.Context;

import com.service.letinvr.letinservice.ui.MainActivity;

/**
 * 站在顶峰,看世界
 * 跌落谷底,思人生
 * 大姨夫 2018\10\20 0020
 **/
public class APP extends Application {

    public static MainActivity mContext;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static Context getContext(){

        return context;
    }
}
