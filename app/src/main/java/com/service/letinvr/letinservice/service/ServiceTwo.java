package com.service.letinvr.letinservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.service.letinvr.letinservice.ui.MainActivity;
import com.service.letinvr.letinservice.utlis.SLog;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 站在顶峰,看世界
 * 跌落谷底,思人生
 * 大姨夫 2018\10\23 0023
 **/
public class ServiceTwo extends Service {
    private static final String TAG = "ServiceTwo";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        SLog.e("onBind: ");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SLog.e("onCreate");
    }

    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {

                @Override
                public void run() {
                    SLog.e("ServiceTwo Run: " + System.currentTimeMillis());
                    boolean b = MainActivity.isServiceWorked(ServiceTwo.this, "com.service.letinvr.letinservice.service.ServiceOne");
                    if (!b) {//如果Service没有运行  那么就启动Service
                        Intent service = new Intent(ServiceTwo.this, ServiceOne.class);
                        startService(service);
                        SLog.e("Start ServiceOne");
                    }
                }
            };
            timer.schedule(task, 0, 1000);// 0延迟  1秒钟检测一次Service 是否被干掉！
        }
    });

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SLog.e("onStartCommand: ");
        thread.start();
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        // 重启自己
        Intent intent = new Intent(getApplicationContext(), ServiceTwo.class);
        startService(intent);
        super.onDestroy();
    }
}
