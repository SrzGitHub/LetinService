package com.service.letinvr.letinservice.moudle.hvsdate;

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
 * 2019/05/08 14:26 星期三
 **/
public class LoginRouteReturn  implements Serializable {


    /**authenticate
     * result : {"retCode":"000000000","retMsg":"dispatch success."}
     * vspURL : http://112.50.238.105:33200
     * vspHttpsURL : https://112.50.238.105:33207
     */

    private ResultBean result;
    private String vspURL;
    private String vspHttpsURL;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getVspURL() {
        return vspURL;
    }

    public void setVspURL(String vspURL) {
        this.vspURL = vspURL;
    }

    public String getVspHttpsURL() {
        return vspHttpsURL;
    }

    public void setVspHttpsURL(String vspHttpsURL) {
        this.vspHttpsURL = vspHttpsURL;
    }

    public static class ResultBean {
        /**
         * retCode : 000000000
         * retMsg : dispatch success.
         */

        private String retCode;
        private String retMsg;

        public String getRetCode() {
            return retCode;
        }

        public void setRetCode(String retCode) {
            this.retCode = retCode;
        }

        public String getRetMsg() {
            return retMsg;
        }

        public void setRetMsg(String retMsg) {
            this.retMsg = retMsg;
        }
    }
}
