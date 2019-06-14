package com.service.letinvr.letinservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.service.letinvr.letinservice.ui.MainActivity;
import com.service.letinvr.letinservice.utlis.LogToFile;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.service.letinvr.letinservice.api.API.SERVICE_ONE;

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
        thread.start();
    }

    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {

            Timer timer = new Timer();

            TimerTask task = new TimerTask() {

                @Override
                public void run() {
                    boolean b = MainActivity.isServiceWorked(LetinServers.this, SERVICE_ONE);
                    if (!b) {//如果Service没有运行  那么就启动Service
                        Intent service = new Intent(LetinServers.this, LetinServer.class);
                        startService(service);
                    }
                }
            };
            timer.schedule(task, 0, 3*60*1000);// 0延迟  1秒钟检测一次Service 是否被干掉！
        }
    });

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
