package com.service.letinvr.letinservice.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.service.letinvr.letinservice.service.ServiceOne;
import com.service.letinvr.letinservice.service.ServiceTwo;
import com.service.letinvr.letinservice.utlis.SLog;


public class ServiceBroadcastReceiver extends BroadcastReceiver {



    private static final String ACTION = "android.intent.action.BOOT_COMPLETED";//开机广播
    private static final String  NOISY_ACTION= "android.media.AUDIO_BECOMING_NOISY";//开机声音
    private static final String packName = "com.service.letinvr.letinservice"; //包名

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();//获取开机action
        SLog.e("action："+action);

        if (action.equals(ACTION)||action.equals(NOISY_ACTION)){
            Intent i = context.getPackageManager().getLaunchIntentForPackage(packName);
            if (i != null) {
                Intent intent1 = new Intent(context, ServiceOne.class);
                context.startService(intent1);
                Intent intent2 =new Intent(context, ServiceTwo.class);
                context.startService(intent2);
                SLog.e("启动-----服务");
            }
        }


    }
}
