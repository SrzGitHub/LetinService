package com.service.letinvr.letinservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.service.letinvr.letinservice.thread.DiscoverSaasThread;
import com.service.letinvr.letinservice.utlis.LogToFile;


/**
 * 站在顶峰,看世界
 * 跌落谷底,思人生
 * 大姨夫 2018\10\23 0023
 **/
public class LetinServers extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogToFile.e("onBind: ");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       new DiscoverSaasThread().start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        // 重启自己
        Intent intent = new Intent(getApplicationContext(), LetinServers.class);
        startService(intent);
        super.onDestroy();
    }
}
