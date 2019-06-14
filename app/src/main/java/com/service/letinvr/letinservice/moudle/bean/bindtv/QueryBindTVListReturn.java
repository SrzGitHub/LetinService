package com.service.letinvr.letinservice.moudle.bean.bindtv;

import java.io.Serializable;
import java.util.List;

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
 * 2019/05/08 10:54 星期三
 **/
public class QueryBindTVListReturn implements Serializable {


    /**
     * data : [{"name":"","shareFlag":"0","signature":"","tvAccount":"vrtest03","xmppAccount":"otta8f470872805"}]
     * mtvAccount : M13859021287
     * returnCode : 0
     * traceID : 2019050811061214735522
     * xmppAccount : M13859021287
     * xmppAddress : 112.5.221.6:5222
     * xmppPwd : QPYWfqubuxO+/X5tXH4BgcXPcMYbOOjQDQllhj1a6C0=
     */

    private String mtvAccount;
    private int returnCode;
    private String traceID;
    private String xmppAccount;
    private String xmppAddress;
    private String xmppPwd;
    private List<DataBean> data;
    private String errorMessage;
    private int errorCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getMtvAccount() {
        return mtvAccount;
    }

    public void setMtvAccount(String mtvAccount) {
        this.mtvAccount = mtvAccount;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getTraceID() {
        return traceID;
    }

    public void setTraceID(String traceID) {
        this.traceID = traceID;
    }

    public String getXmppAccount() {
        return xmppAccount;
    }

    public void setXmppAccount(String xmppAccount) {
        this.xmppAccount = xmppAccount;
    }

    public String getXmppAddress() {
        return xmppAddress;
    }

    public void setXmppAddress(String xmppAddress) {
        this.xmppAddress = xmppAddress;
    }

    public String getXmppPwd() {
        return xmppPwd;
    }

    public void setXmppPwd(String xmppPwd) {
        this.xmppPwd = xmppPwd;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name :
         * shareFlag : 0
         * signature :
         * tvAccount : vrtest03
         * xmppAccount : otta8f470872805
         */

        private String name;
        private String shareFlag;
        private String signature;
        private String tvAccount;
        private String xmppAccount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShareFlag() {
            return shareFlag;
        }

        public void setShareFlag(String shareFlag) {
            this.shareFlag = shareFlag;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getTvAccount() {
            return tvAccount;
        }

        public void setTvAccount(String tvAccount) {
            this.tvAccount = tvAccount;
        }

        public String getXmppAccount() {
            return xmppAccount;
        }

        public void setXmppAccount(String xmppAccount) {
            this.xmppAccount = xmppAccount;
        }
    }
}
