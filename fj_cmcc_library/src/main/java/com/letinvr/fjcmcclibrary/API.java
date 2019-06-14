package com.letinvr.fjcmcclibrary;

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
 * 2019/05/23 15:14 星期四
 **/
public class API {
    /**
     * 向其他应用发送广播
     * 接收其他应用广播
     */
    public static final String ACTION_SERVER_MESSAGE="com.letinvr.send.message";
    public static final String ACTION_SERVER_MESSAGE_SEND ="com.letinvr.send.message.send";
    public static final String ACTION_POST_URL = "url";
    public static final String ACTION_POST_JSON = "json";
    public static final String ACTION_POST_COOKIE = "cookie";

    public static final String ACTION_LANTING_MESSAGE = "com.picovr.lanting.message";
    public static final String SEND_XMPP_MSG = "sendXMPPMsg";
    public static final String SEND_XMPP_TV = "sendTvAccount";

    public static final String LETIN_MSG = "LetinMessage";
    public static final String LETIN_MSG_CALLBACK = "LetinOnReceiveMessageCallback";
}
