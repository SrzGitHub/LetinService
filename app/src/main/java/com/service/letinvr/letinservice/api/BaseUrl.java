package com.service.letinvr.letinservice.api;

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
 * 2019/05/06 16:10 星期一
 **/
public class BaseUrl {

    public static final String HTTP = "https://fjbmvapp.hvs.fj.chinamobile.com:9005/appRegister";//

    public static final String HTTPS = "http://112.50.235.55:8082/EDS/V3/LoginRoute";

    public static final String LT_EPG_URL = "http://shop.letinvr.com/api/login/";
    //获取授权验证码
    public static final String GET_VERIFY_CODE = HTTP + "/getVerifyCode";
    //查询授权关系
    public static final String QUERY_AUTHORIZATION_REL = HTTP + "/queryAuthorizationRel";
    //一体机授权登录信息
    public static final String QUERY_VERIFY_CODE = HTTP + "/queryVerifyCode";
    //解除授权关系
    public static final String UNBIND_AUTHORIZATION_REL = HTTP + "/unBindAuthorizationRel";
    //VR查询app绑定TV
    public static final String QUERY_BIND_TVLIST = HTTP + "/queryBindTVList";


    public static final String VSP_HTTPS_URL = "vspHttpsURL";
    public static final String VSP_URL = "vspURL";
    //HVS认证
    public static final String VSP_V3_AUTHENTICATE = "/VSP/V3/Authenticate";
    //HVS心跳
    public static final String VSP_V3_ONLINE_HEARTBEAT = "/VSP/V3/OnLineHeartbeat";
    //HVS退出登录
    public static final String VSP_V3_LOGOUT = "/VSP/V3/Logout";
    public static final String VAP_PARAS = "{\"authenticateBasic\":{\"userID\":\"guestid\",\"userType\":0,\"clientPasswd\":\"a123456\"},\"authenticateDevice\":{\"deviceModel\":\"AndroidPhone\"}}";
//user session not found or timeout


}
