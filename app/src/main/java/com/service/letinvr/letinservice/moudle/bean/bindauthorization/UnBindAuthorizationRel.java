package com.service.letinvr.letinservice.moudle.bean.bindauthorization;

import java.io.Serializable;

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
 * 2019/05/07 14:28 星期二
 **/
public class UnBindAuthorizationRel implements Serializable {

    //解除绑定

    /**
     * appId : 10011
     * timestamp : 20180427104700
     * token : Ig9z1wRhO1RrigFaesaeA+pDwqoG+/xeL6gLhoARVDk=
     * VRId : XXXXXXXXXXXXXXXXXXXX
     * mtvAccount : M12345678912
     */

    private String appId;
    private String timestamp;
    private String token;
    private String VRId;
    private String mtvAccount;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVRId() {
        return VRId;
    }

    public void setVRId(String VRId) {
        this.VRId = VRId;
    }

    public String getMtvAccount() {
        return mtvAccount;
    }

    public void setMtvAccount(String mtvAccount) {
        this.mtvAccount = mtvAccount;
    }


}