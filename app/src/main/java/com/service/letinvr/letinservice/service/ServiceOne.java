package com.service.letinvr.letinservice.service;


//
//                    .::::.
//                  .::::::::.
//                 :::::::::::  FUCK YOU
//             ..:::::::::::'
//           '::::::::::::'
//             .::::::::::
//        '::::::::::::::..
//             ..::::::::::::.
//           ``::::::::::::::::
//            ::::``:::::::::'        .:::.
//           ::::'   ':::::'       .::::::::.
//         .::::'      ::::     .:::::::'::::.
//        .:::'       :::::  .:::::::::' ':::::.
//       .::'        :::::.:::::::::'      ':::::.
//      .::'         ::::::::::::::'         ``::::.
//  ...:::           ::::::::::::'              ``::.
// ```` ':.          ':::::::::'                  ::::..
//                    '.:::::'                    ':'````..

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.service.letinvr.letinservice.ui.MainActivity;
import com.service.letinvr.letinservice.utlis.SLog;

import java.util.Timer;
import java.util.TimerTask;

import static com.service.letinvr.letinservice.api.API.DATE;
import static com.service.letinvr.letinservice.api.API.RECEIVER_RADIO;
import static com.service.letinvr.letinservice.api.API.SEND_BROADCAST;

/***********************************************************
 *                                                         *
 * You may think you know what the following code does.    *
 * But you dont. Trust me.                                 *
 * Fiddle with it, and youll spend many a sleepless        *
 * night cursing the moment you thought youd be clever     *
 * enough to "optimize" the code below.                    *
 * Now close this file and go play with something else.    *
 *                                                         *
 *              2018/11/13 16:44                           *
 ***********************************************************/
public class ServiceOne extends Service {
    private static final String MESSAGE_ACTION = "com.service.MAIN_SERVICE_ACTION";
    public int MAX = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        SLog.e("onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        IntentFilter filter = new IntentFilter();
        filter.addAction(MESSAGE_ACTION);//其他应用
        filter.addAction(SEND_BROADCAST);//VR广播
        registerReceiver(receiver, filter);

        SLog.e("onCreate");
    }
    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {

                @Override
                public void run() {
                    SLog.e("ServiceOne Run: "+System.currentTimeMillis());
                    boolean b = MainActivity.isServiceWorked(ServiceOne.this, "com.service.letinvr.letinservice.service.ServiceTwo");
                    if(!b) {
                        Intent service = new Intent(ServiceOne.this, ServiceTwo.class);
                        startService(service);
                        SLog.e("Start ServiceTwo");

                    }
                }
            };
            timer.schedule(task, 0, 1000);
        }
    });

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SLog.e("onStartCommand: ");
//        return super.onStartCommand(intent, flags, startId);
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        // 重启自己
        Intent intent = new Intent(getApplicationContext(),ServiceOne.class);
        startService(intent);
        super.onDestroy();
    }


    //接收其他应用发来广播
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            String action = intent.getAction();
            if (!action.isEmpty() && action.equals(SEND_BROADCAST)) {
                SLog.e("=>=>=>=>=>=>：" + action);
                String date = intent.getStringExtra(DATE);
                if (!date.isEmpty()) {
                    SLog.e("收到广播："+date);
                    sendBroadcast("LetinServiceh回复-");
                } else {
                    SLog.e("空空如也：");
                }
            } else {
                SLog.e("没有具体命令！");
            }


        }
    };

    public void sendBroadcast(final String msg) {

        MAX++;
        Intent intent = new Intent();
        intent.setAction(RECEIVER_RADIO);
        intent.putExtra("send", msg + MAX);
        sendBroadcast(intent);
        SLog.e("成功回复广播");
    }
}
