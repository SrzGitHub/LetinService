package com.service.letinvr.letinservice.api;

import android.content.Context;
import android.os.Build;

import com.google.gson.Gson;
import com.service.letinvr.letinservice.app.APP;
import com.service.letinvr.letinservice.utlis.Base64Utils;
import com.service.letinvr.letinservice.utlis.SHA256;
import com.service.letinvr.letinservice.utlis.SPUtils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
 * 2019/05/11 16:19 星期六
 **/
public class PresenterConstant {
    public static final int POST_CODE_101 = 100101;
    public static final int POST_CODE_102 = 100102;
    public static final int POST_CODE_103 = 100103;
    public static final int POST_CODE_104 = 100104;
    public static final int POST_CODE_105 = 100105;
    public static final int POST_CODE_106 = 100106;
    public static final int POST_CODE_107 = 100107;
    public static final int POST_CODE_108 = 100108;
    public static final int POST_CODE_109 = 100109;
    public static final int POST_CODE_110 = 100110;
    public static final int POST_CODE_111 = 100111;
    public static final int POST_CODE_112 = 100112;
    public static final int POST_CODE_113 = 100113;
    public static final int POST_CODE_114 = 100114;
    public static final int POST_CODE_115 = 100115;

    public static final String KEY = "VRClient@Key0000";
    public static final String VR_KEY = "VRClient!@FJCMCC";
    public static final String APP_ID = "10011";


    //Json转换
    public static String getJson(Object o) {
        return new Gson().toJson(o);
    }

    public static String getToken(String data) {
        return Base64Utils.encode(SHA256.shaEncrypt(APP_ID + data + VR_KEY));
    }

    //获取token
    public static String getSign(String code) {

        String getMac = Constant.getMAC();
        String shar = getMac + "&" + code + VR_KEY;
        byte[] bytes = SHA256.shaEncrypt(shar);
        //SHA256.shaEncrypt(MacUtils.getMac(APP.getInstance()) + "&" + code + VR_KEY)
        return Base64Utils.encode(bytes);
    }


    //获取手机型号
    public static String getDeviceModel() {
        return Build.MODEL;
    }

    //获取时间戳
    public static long currentTimestamp() {
        return System.currentTimeMillis();
    }

    //获取当前时间
    public static String stampToDate() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(currentTimestamp());
        return simpleDateFormat.format(date);
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDates(long s) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(s);
        return hms;
    }

    public static void putKey(String key, String value) {
        SPUtils.put(APP.getContext(), key, value);
    }

    public static String getKey(String key) {
        return (String) SPUtils.get(APP.getContext(), key, "");
    }
}
