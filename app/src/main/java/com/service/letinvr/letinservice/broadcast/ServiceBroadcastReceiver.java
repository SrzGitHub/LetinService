package com.service.letinvr.letinservice.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.service.letinvr.letinservice.api.API;
import com.service.letinvr.letinservice.service.LetinServer;
import com.service.letinvr.letinservice.service.LetinServers;
import com.service.letinvr.letinservice.utlis.LogToFile;


public class ServiceBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();//获取开机action
        LogToFile.e("Srz_    --->   "+action);
        if (action.equals(API.ACTION_BOOT_COMPLETED)||action.equals(API.ACTION_AUDIO_BECOMING_NOISY)
                /*||action.equals(Intent.ACTION_SCREEN_ON)||action.equals(Intent.ACTION_USER_PRESENT)*/){

            Intent i = context.getPackageManager().getLaunchIntentForPackage(API.ACTION_SERVER_PACK_NAME);
            if (i != null) {
                Intent intent1 = new Intent(context, LetinServer.class);
                context.startService(intent1);
                Intent intent2 =new Intent(context, LetinServers.class);
                context.startService(intent2);
                LogToFile.e("启动-----服务");

            }
        }


    }
}
