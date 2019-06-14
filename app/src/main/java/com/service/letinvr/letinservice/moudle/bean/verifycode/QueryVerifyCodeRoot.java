package com.service.letinvr.letinservice.moudle.bean.verifycode;

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
 * 2019/05/07 20:44 星期二
 **/
public class QueryVerifyCodeRoot implements Serializable {

    /**
     * traceID : 2019050720415496132147
     * returnCode : 0
     * interval : 0
     * status : 1
     * xmppAccountPwd : vZB7SXxUw22OvUD0yk+utOQdp7djmwEDhvysBt1VGT7fyzxZPdua4MBxhaF2iVga
     * accountPwd : kt4/9EN4cxZlrZS5f4IkieeSp/kCxEK6OvfKqGC9Nik=
     */

    private String traceID;
    private int returnCode;
    private String interval;
    private String status;
    private String xmppAccountPwd;
    private String accountPwd;

    public String getTraceID() {
        return traceID;
    }

    public void setTraceID(String traceID) {
        this.traceID = traceID;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getXmppAccountPwd() {
        return xmppAccountPwd;
    }

    public void setXmppAccountPwd(String xmppAccountPwd) {
        this.xmppAccountPwd = xmppAccountPwd;
    }

    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }
}
