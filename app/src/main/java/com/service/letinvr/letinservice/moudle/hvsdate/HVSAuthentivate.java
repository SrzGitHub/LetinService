package com.service.letinvr.letinservice.moudle.hvsdate;

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
 * 2019/05/10 17:19 星期五
 **/
public class HVSAuthentivate implements Serializable {


    /**
     * authenticateBasic : {"clientPasswd":"rHMEtk","extensionFields":[{"key":"clientID","values":["AndroidPhone"]}],"userID":"M13859021287","userType":0}
     * authenticateDevice : {"deviceModel":"AndroidPhone","physicalDeviceID":"M1385902128700:0A:F5:E0:7C:2B"}
     */

    private AuthenticateBasicBean authenticateBasic;
    private AuthenticateDeviceBean authenticateDevice;

    public AuthenticateBasicBean getAuthenticateBasic() {
        return authenticateBasic;
    }

    public void setAuthenticateBasic(AuthenticateBasicBean authenticateBasic) {
        this.authenticateBasic = authenticateBasic;
    }

    public AuthenticateDeviceBean getAuthenticateDevice() {
        return authenticateDevice;
    }

    public void setAuthenticateDevice(AuthenticateDeviceBean authenticateDevice) {
        this.authenticateDevice = authenticateDevice;
    }

    public static class AuthenticateBasicBean {
        /**
         * clientPasswd : rHMEtk
         * extensionFields : [{"key":"clientID","values":["AndroidPhone"]}]
         * userID : M13859021287
         * userType : 0
         */

        private String clientPasswd;
        private String userID;
        private int userType;
        private List<ExtensionFieldsBean> extensionFields;

        public String getClientPasswd() {
            return clientPasswd;
        }

        public void setClientPasswd(String clientPasswd) {
            this.clientPasswd = clientPasswd;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public List<ExtensionFieldsBean> getExtensionFields() {
            return extensionFields;
        }

        public void setExtensionFields(List<ExtensionFieldsBean> extensionFields) {
            this.extensionFields = extensionFields;
        }

        public static class ExtensionFieldsBean {
            /**
             * key : clientID
             * values : ["AndroidPhone"]
             */

            private String key;
            private List<String> values;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public List<String> getValues() {
                return values;
            }

            public void setValues(List<String> values) {
                this.values = values;
            }
        }
    }

    public static class AuthenticateDeviceBean {
        /**
         * deviceModel : AndroidPhone
         * physicalDeviceID : M1385902128700:0A:F5:E0:7C:2B
         */

        private String deviceModel;
        private String physicalDeviceID;

        public String getDeviceModel() {
            return deviceModel;
        }

        public void setDeviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
        }

        public String getPhysicalDeviceID() {
            return physicalDeviceID;
        }

        public void setPhysicalDeviceID(String physicalDeviceID) {
            this.physicalDeviceID = physicalDeviceID;
        }
    }
}
