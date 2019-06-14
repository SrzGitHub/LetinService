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
 * 2019/05/08 16:05 星期三
 **/
public class SessionIDDate  implements Serializable {


    /**
     * RRSAddr : http://112.50.233.156
     * antiTamperURI : [{"key":"PlayVOD","values":["VODID,mediaID;result.retCode,authorizeResult.productID,playURL"]},{"key":"SubscribeProduct","values":["productID;result.retCode"]},{"key":"PlayChannel","values":["channelID,mediaID,businessType;result.retCode,authorizeResult.productID,playURL"]},{"key":"QueryChannelListByCategory","values":["categoryID,count;total,channelDetails.id,physicalChannels.btvCR.isSubscribed,physicalChannels.pltvCR.isSubscribed,physicalChannels.cutvCR.isSubscribed,physicalChannels.cpvrCR.isSubscribed,physicalChannels.npvrCR.isSubscribed,physicalChannels.cpltvCR.isSubscribed,physicalChannels.irCR.isSubscribed,physicalChannels.cpvrRecCR.isSubscribed,physicalChannels.npvrRecCR.isSubscribed"]}]
     * areaCode : 10222
     * bandWidth : -1
     * cSessionId : 12768C519EFA442D64ACF0FD3B4E9BBA
     * channelNamespace : 3
     * deviceID : 7032e407162ab1bec2f18433848689896129835
     * hasCollectUserPreference : 0
     * isFirstLogin : 1
     * isTriplePlay : 0
     * jSessionID : 01QY1BX3RC57FVMM4KOU0N2KV5HC9VZQ
     * loginOccasion : 0
     * needSignPrivacyStatement : 0
     * opt : 0
     * profileID : guestid
     * profileSN : 100002692
     * profiles : [{"ID":"guestid","channelListType":"1","createTime":"0","hasCollectUserPreference":"0","isDefaultProfile":"0","isDisplayInfoBar":"0","isFilterLevel":"0","isNeedSubscribePIN":"1","isOnline":"0","isReceiveSMS":"1","isSendSMSForReminder":"0","isShowMessage":"0","lang":"zh","leadTimeForSendReminder":"5","loginName":"guestid","multiscreenEnable":"0","name":"guestid","profilePINEnable":"1","profileType":"0","purchaseEnable":"1","pushStatus":"1","quota":"-1","ratingID":"4","ratingName":"其它","reminderInterval":"5","subscriberID":"guestid"}]
     * result : {"retCode":"000000000","retMsg":"Successfully"}
     * subnetID : 8601
     * subscriberID : guestid
     * templateName : BestvEPG
     * timeZone : GMT+08:00
     * userFilter : -2068165936
     * userGroup : -1
     * userPlaybillDetailFilter : -366585363
     * userPlaybillListFilter : -366585363
     * userToken : 79bhN79bhN1vp2tVgxxcAmjFx0ttGfjS
     * userVODDetailFilter : -1468407596
     * userVODListFilter : -1468407596
     */

    private String RRSAddr;
    private String areaCode;
    private String bandWidth;
    private String cSessionId;
    private String channelNamespace;
    private String deviceID;
    private String hasCollectUserPreference;
    private String isFirstLogin;
    private String isTriplePlay;
    private String jSessionID;
    private String loginOccasion;
    private String needSignPrivacyStatement;
    private String opt;
    private String profileID;
    private String profileSN;
    private ResultBean result;
    private String subnetID;
    private String subscriberID;
    private String templateName;
    private String timeZone;
    private String userFilter;
    private String userGroup;
    private String userPlaybillDetailFilter;
    private String userPlaybillListFilter;
    private String userToken;
    private String userVODDetailFilter;
    private String userVODListFilter;
    private List<AntiTamperURIBean> antiTamperURI;
    private List<ProfilesBean> profiles;

    public String getRRSAddr() {
        return RRSAddr;
    }

    public void setRRSAddr(String RRSAddr) {
        this.RRSAddr = RRSAddr;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(String bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getCSessionId() {
        return cSessionId;
    }

    public void setCSessionId(String cSessionId) {
        this.cSessionId = cSessionId;
    }

    public String getChannelNamespace() {
        return channelNamespace;
    }

    public void setChannelNamespace(String channelNamespace) {
        this.channelNamespace = channelNamespace;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getHasCollectUserPreference() {
        return hasCollectUserPreference;
    }

    public void setHasCollectUserPreference(String hasCollectUserPreference) {
        this.hasCollectUserPreference = hasCollectUserPreference;
    }

    public String getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(String isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public String getIsTriplePlay() {
        return isTriplePlay;
    }

    public void setIsTriplePlay(String isTriplePlay) {
        this.isTriplePlay = isTriplePlay;
    }

    public String getJSessionID() {
        return jSessionID;
    }

    public void setJSessionID(String jSessionID) {
        this.jSessionID = jSessionID;
    }

    public String getLoginOccasion() {
        return loginOccasion;
    }

    public void setLoginOccasion(String loginOccasion) {
        this.loginOccasion = loginOccasion;
    }

    public String getNeedSignPrivacyStatement() {
        return needSignPrivacyStatement;
    }

    public void setNeedSignPrivacyStatement(String needSignPrivacyStatement) {
        this.needSignPrivacyStatement = needSignPrivacyStatement;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getProfileSN() {
        return profileSN;
    }

    public void setProfileSN(String profileSN) {
        this.profileSN = profileSN;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getSubnetID() {
        return subnetID;
    }

    public void setSubnetID(String subnetID) {
        this.subnetID = subnetID;
    }

    public String getSubscriberID() {
        return subscriberID;
    }

    public void setSubscriberID(String subscriberID) {
        this.subscriberID = subscriberID;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getUserFilter() {
        return userFilter;
    }

    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getUserPlaybillDetailFilter() {
        return userPlaybillDetailFilter;
    }

    public void setUserPlaybillDetailFilter(String userPlaybillDetailFilter) {
        this.userPlaybillDetailFilter = userPlaybillDetailFilter;
    }

    public String getUserPlaybillListFilter() {
        return userPlaybillListFilter;
    }

    public void setUserPlaybillListFilter(String userPlaybillListFilter) {
        this.userPlaybillListFilter = userPlaybillListFilter;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserVODDetailFilter() {
        return userVODDetailFilter;
    }

    public void setUserVODDetailFilter(String userVODDetailFilter) {
        this.userVODDetailFilter = userVODDetailFilter;
    }

    public String getUserVODListFilter() {
        return userVODListFilter;
    }

    public void setUserVODListFilter(String userVODListFilter) {
        this.userVODListFilter = userVODListFilter;
    }

    public List<AntiTamperURIBean> getAntiTamperURI() {
        return antiTamperURI;
    }

    public void setAntiTamperURI(List<AntiTamperURIBean> antiTamperURI) {
        this.antiTamperURI = antiTamperURI;
    }

    public List<ProfilesBean> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfilesBean> profiles) {
        this.profiles = profiles;
    }

    public static class ResultBean {
        /**
         * retCode : 000000000
         * retMsg : Successfully
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

    public static class AntiTamperURIBean {
        /**
         * key : PlayVOD
         * values : ["VODID,mediaID;result.retCode,authorizeResult.productID,playURL"]
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

    public static class ProfilesBean {
        /**
         * ID : guestid
         * channelListType : 1
         * createTime : 0
         * hasCollectUserPreference : 0
         * isDefaultProfile : 0
         * isDisplayInfoBar : 0
         * isFilterLevel : 0
         * isNeedSubscribePIN : 1
         * isOnline : 0
         * isReceiveSMS : 1
         * isSendSMSForReminder : 0
         * isShowMessage : 0
         * lang : zh
         * leadTimeForSendReminder : 5
         * loginName : guestid
         * multiscreenEnable : 0
         * name : guestid
         * profilePINEnable : 1
         * profileType : 0
         * purchaseEnable : 1
         * pushStatus : 1
         * quota : -1
         * ratingID : 4
         * ratingName : 其它
         * reminderInterval : 5
         * subscriberID : guestid
         */

        private String ID;
        private String channelListType;
        private String createTime;
        private String hasCollectUserPreference;
        private String isDefaultProfile;
        private String isDisplayInfoBar;
        private String isFilterLevel;
        private String isNeedSubscribePIN;
        private String isOnline;
        private String isReceiveSMS;
        private String isSendSMSForReminder;
        private String isShowMessage;
        private String lang;
        private String leadTimeForSendReminder;
        private String loginName;
        private String multiscreenEnable;
        private String name;
        private String profilePINEnable;
        private String profileType;
        private String purchaseEnable;
        private String pushStatus;
        private String quota;
        private String ratingID;
        private String ratingName;
        private String reminderInterval;
        private String subscriberID;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getChannelListType() {
            return channelListType;
        }

        public void setChannelListType(String channelListType) {
            this.channelListType = channelListType;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getHasCollectUserPreference() {
            return hasCollectUserPreference;
        }

        public void setHasCollectUserPreference(String hasCollectUserPreference) {
            this.hasCollectUserPreference = hasCollectUserPreference;
        }

        public String getIsDefaultProfile() {
            return isDefaultProfile;
        }

        public void setIsDefaultProfile(String isDefaultProfile) {
            this.isDefaultProfile = isDefaultProfile;
        }

        public String getIsDisplayInfoBar() {
            return isDisplayInfoBar;
        }

        public void setIsDisplayInfoBar(String isDisplayInfoBar) {
            this.isDisplayInfoBar = isDisplayInfoBar;
        }

        public String getIsFilterLevel() {
            return isFilterLevel;
        }

        public void setIsFilterLevel(String isFilterLevel) {
            this.isFilterLevel = isFilterLevel;
        }

        public String getIsNeedSubscribePIN() {
            return isNeedSubscribePIN;
        }

        public void setIsNeedSubscribePIN(String isNeedSubscribePIN) {
            this.isNeedSubscribePIN = isNeedSubscribePIN;
        }

        public String getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(String isOnline) {
            this.isOnline = isOnline;
        }

        public String getIsReceiveSMS() {
            return isReceiveSMS;
        }

        public void setIsReceiveSMS(String isReceiveSMS) {
            this.isReceiveSMS = isReceiveSMS;
        }

        public String getIsSendSMSForReminder() {
            return isSendSMSForReminder;
        }

        public void setIsSendSMSForReminder(String isSendSMSForReminder) {
            this.isSendSMSForReminder = isSendSMSForReminder;
        }

        public String getIsShowMessage() {
            return isShowMessage;
        }

        public void setIsShowMessage(String isShowMessage) {
            this.isShowMessage = isShowMessage;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getLeadTimeForSendReminder() {
            return leadTimeForSendReminder;
        }

        public void setLeadTimeForSendReminder(String leadTimeForSendReminder) {
            this.leadTimeForSendReminder = leadTimeForSendReminder;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getMultiscreenEnable() {
            return multiscreenEnable;
        }

        public void setMultiscreenEnable(String multiscreenEnable) {
            this.multiscreenEnable = multiscreenEnable;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfilePINEnable() {
            return profilePINEnable;
        }

        public void setProfilePINEnable(String profilePINEnable) {
            this.profilePINEnable = profilePINEnable;
        }

        public String getProfileType() {
            return profileType;
        }

        public void setProfileType(String profileType) {
            this.profileType = profileType;
        }

        public String getPurchaseEnable() {
            return purchaseEnable;
        }

        public void setPurchaseEnable(String purchaseEnable) {
            this.purchaseEnable = purchaseEnable;
        }

        public String getPushStatus() {
            return pushStatus;
        }

        public void setPushStatus(String pushStatus) {
            this.pushStatus = pushStatus;
        }

        public String getQuota() {
            return quota;
        }

        public void setQuota(String quota) {
            this.quota = quota;
        }

        public String getRatingID() {
            return ratingID;
        }

        public void setRatingID(String ratingID) {
            this.ratingID = ratingID;
        }

        public String getRatingName() {
            return ratingName;
        }

        public void setRatingName(String ratingName) {
            this.ratingName = ratingName;
        }

        public String getReminderInterval() {
            return reminderInterval;
        }

        public void setReminderInterval(String reminderInterval) {
            this.reminderInterval = reminderInterval;
        }

        public String getSubscriberID() {
            return subscriberID;
        }

        public void setSubscriberID(String subscriberID) {
            this.subscriberID = subscriberID;
        }
    }
}
