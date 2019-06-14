package com.letinvr.fjcmcclibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.unity3d.player.UnityPlayer;

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
 * 2019/05/23 15:12 星期四
 **/
public class LetinServerBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (API.ACTION_SERVER_MESSAGE.equals(intent.getAction())){
            String unityMsg = intent.getStringExtra("unityMsg");
            LogToFile.e("Srz ---> LetinServer消息  "+unityMsg);
            UnityPlayer.UnitySendMessage(API.LETIN_MSG, API.LETIN_MSG_CALLBACK, unityMsg);
        }
    }
}
