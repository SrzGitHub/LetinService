package com.service.letinvr.letinservice.thread;

import android.content.Intent;

import com.service.letinvr.letinservice.api.API;
import com.service.letinvr.letinservice.app.APP;
import com.service.letinvr.letinservice.service.LetinServer;
import com.service.letinvr.letinservice.ui.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * //                    .::::.
 * //                  .::::::::.
 * //                 :::::::::::  FUCK YOU
 * //             ..:::::::::::'
 * //           '::::::::::::'
 * //             .::::::::::
 * //        '::::::::::::::..
 * //             ..::::::::::::.
 * //           ``::::::::::::::::
 * //            ::::``:::::::::'        .:::.
 * //           ::::'   ':::::'       .::::::::.
 * //         .::::'      ::::     .:::::::'::::.
 * //        .:::'       :::::  .:::::::::' ':::::.
 * //       .::'        :::::.:::::::::'      ':::::.
 * //      .::'         ::::::::::::::'         ``::::.
 * //  ...:::           ::::::::::::'              ``::.
 * // ```` ':.          ':::::::::'                  ::::..
 * //                    '.:::::'                    ':'````..
 * ===========================================================
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 * <p>
 * 2019/09/11 11:35 星期三
 **/
public class DiscoverSaasThread extends Thread {

    private final Timer timer;
    private TimerTask task;

    public DiscoverSaasThread(){

        timer = new Timer();
    }

    @Override
    public void run() {
        task = new TimerTask() {
            @Override//constant
            public void run() {

                boolean b = MainActivity.isServiceWorked(APP.getContext(), API.SERVICE_ONE);

                if (!b) {//如果Service没有运行  那么就启动Service
                    Intent service = new Intent(APP.getContext(), LetinServer.class);
                    APP.getContext().startService(service);
                }
            }
        };
        timer.schedule(task, 0, 5*60*1000);// 0延迟  5分钟检测一次Service 是否被干掉！
        
        
    }
}
