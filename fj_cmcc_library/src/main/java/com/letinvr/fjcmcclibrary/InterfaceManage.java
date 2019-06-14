package com.letinvr.fjcmcclibrary;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;


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
 * 2019/05/15 09:59 星期三
 **/
public class InterfaceManage {


    public static void sendXMPPBroadcast(final Activity context, final String xmppMsg, final String tvAccount) {
        //发送XMPP消息
        Intent sendMsg = new Intent();
        sendMsg.setAction(API.ACTION_LANTING_MESSAGE);
        sendMsg.putExtra(API.SEND_XMPP_MSG, xmppMsg);
        sendMsg.putExtra(API.SEND_XMPP_TV, tvAccount);
        context.sendBroadcast(sendMsg);
        LogToFile.e("Srz ---> 发送XMPP消息  " + xmppMsg + " , tvAccount " + tvAccount);
    }

    public static void pollingAuthorization(Activity context) {

        //轮询授权关系
        Intent pollIntent = new Intent();
        pollIntent.setAction(API.ACTION_SERVER_MESSAGE_SEND);
        pollIntent.putExtra("message", "Authorize");
        context.sendBroadcast(pollIntent);
        LogToFile.e("Srz ---> 轮询授权关系  ");
    }

    public static void getVerificationCode(final Activity context) {
        Intent pollIntent = new Intent();
        pollIntent.setAction(API.ACTION_SERVER_MESSAGE_SEND);
        pollIntent.putExtra("message", "VerificationCode");
        context.sendBroadcast(pollIntent);
        LogToFile.e("Srz ---> 获取验证码  ");
    }


    public static void queryBindTVList(final Activity context) {
        Intent pollIntent = new Intent();
        pollIntent.setAction(API.ACTION_SERVER_MESSAGE_SEND);
        pollIntent.putExtra("message", "BindTV");
        context.sendBroadcast(pollIntent);
        LogToFile.e("Srz ---> 获取绑定机顶盒  ");
    }

    public static void loginOut(final Activity context) {
        Intent pollIntent = new Intent();
        pollIntent.setAction(API.ACTION_SERVER_MESSAGE_SEND);
        pollIntent.putExtra("message", "LoginOut");
        context.sendBroadcast(pollIntent);
        LogToFile.e("Srz ---> 退出所有登录  ");
    }

    public static void postRequest(final Activity context, final String url, final String json, final String cookie) {
        Intent postHttp = new Intent();
        postHttp.setAction(API.ACTION_SERVER_MESSAGE_SEND);
        postHttp.putExtra("message", "postRequest");
        postHttp.putExtra(API.ACTION_POST_URL, url);
        postHttp.putExtra(API.ACTION_POST_JSON, json);
        postHttp.putExtra(API.ACTION_POST_COOKIE, cookie);
        context.sendBroadcast(postHttp);
        LogToFile.e("Srz --->  post请求" + url + "--" + json + "--" + cookie);

    }

    public void initBroadcast(Activity activity) {
        LetinServerBroadcastReceiver receiver = new LetinServerBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(API.ACTION_SERVER_MESSAGE);
        intentFilter.addAction(API.ACTION_SERVER_MESSAGE_SEND);
        intentFilter.addAction(API.ACTION_LANTING_MESSAGE);
        activity.registerReceiver(receiver, intentFilter);
        LogToFile.e("Srz ---> 注册广播！！！  ");
    }


}
