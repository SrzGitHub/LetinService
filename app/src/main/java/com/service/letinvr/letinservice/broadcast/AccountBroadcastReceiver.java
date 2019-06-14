package com.service.letinvr.letinservice.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.service.letinvr.letinservice.api.API;
import com.service.letinvr.letinservice.utlis.LogToFile;



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
 * 2019/05/14 15:32 星期二
 **/
public class AccountBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String response = intent.getStringExtra("response");
        LogToFile.e("Srz ---> xmppaCTION  "+intent.getAction());
        if (response!=null){
            LogToFile.e("Srz --->  转发XMPP消息 "+response);
            sendUnityMsg(context,"XMPPMsg|"+response);

        }



    }
    //传给Unity层消息
    public void sendUnityMsg(Context context, final String msg) {
        LogToFile.e("Srz ---> 发送Unity 消息 " + msg);
        Intent intent = new Intent();
        intent.setAction(API.ACTION_SERVER_MESSAGE);
        intent.putExtra("unityMsg", msg);
        context.sendBroadcast(intent);
    }
}
