package com.service.letinvr.letinservice.base;

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

import android.app.Activity;

import java.util.Map;

/***********************************************************
 *                                                         *
 * You may think you know what the following code does.    *
 * But you dont. Trust me.                                 *
 * Fiddle with it, and youll spend many a sleepless        *
 * night cursing the moment you thought youd be clever     *
 * enough to "optimize" the code below.                    *
 * Now close this file and go play with something else.    *
 *                                                         *
 ***********************************************************/

public interface BasePresenter {
    void start(final String url, final String postJson, final String cookie,int index);
    void start(final String url, final Map<String,String> mMap, final String cookie, int index);
}
