package com.service.letinvr.letinservice.moudle.hvsdate;

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
 * 2019/05/08 16:52 星期三
 **/
public class HeartBsatReturn {


    /**
     * areaCode : 2222
     * nextCallInterval : 900
     * opt : 0
     * personalDataVersions : {"bookmark":"0","channel":"1556205644384|1503564963115","favorite":"0","lock":"0","profile":"1500212261213","reminder":"0"}
     * result : {"retCode":"000000000","retMsg":"Successfully"}
     * subscriberID : guestid
     * templateTimeStamp : 1500130553000
     * userFilter : -1985187421
     * userGroup : -1
     * userPlaybillDetailFilter : -291548452
     * userPlaybillListFilter : -291548452
     * userToken : 79cdl79cdl3s6aIVLIxj3qjGr6MQRnI3
     * userVODDetailFilter : -515915582
     * userVODListFilter : -515915582
     * userValid : true
     */

    private String areaCode;
    private String nextCallInterval;
    private String opt;
    private PersonalDataVersionsBean personalDataVersions;
    private ResultBean result;
    private String subscriberID;
    private String templateTimeStamp;
    private String userFilter;
    private String userGroup;
    private String userPlaybillDetailFilter;
    private String userPlaybillListFilter;
    private String userToken;
    private String userVODDetailFilter;
    private String userVODListFilter;
    private String userValid;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNextCallInterval() {
        return nextCallInterval;
    }

    public void setNextCallInterval(String nextCallInterval) {
        this.nextCallInterval = nextCallInterval;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public PersonalDataVersionsBean getPersonalDataVersions() {
        return personalDataVersions;
    }

    public void setPersonalDataVersions(PersonalDataVersionsBean personalDataVersions) {
        this.personalDataVersions = personalDataVersions;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getSubscriberID() {
        return subscriberID;
    }

    public void setSubscriberID(String subscriberID) {
        this.subscriberID = subscriberID;
    }

    public String getTemplateTimeStamp() {
        return templateTimeStamp;
    }

    public void setTemplateTimeStamp(String templateTimeStamp) {
        this.templateTimeStamp = templateTimeStamp;
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

    public String getUserValid() {
        return userValid;
    }

    public void setUserValid(String userValid) {
        this.userValid = userValid;
    }

    public static class PersonalDataVersionsBean {
        /**
         * bookmark : 0
         * channel : 1556205644384|1503564963115
         * favorite : 0
         * lock : 0
         * profile : 1500212261213
         * reminder : 0
         */

        private String bookmark;
        private String channel;
        private String favorite;
        private String lock;
        private String profile;
        private String reminder;

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getFavorite() {
            return favorite;
        }

        public void setFavorite(String favorite) {
            this.favorite = favorite;
        }

        public String getLock() {
            return lock;
        }

        public void setLock(String lock) {
            this.lock = lock;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getReminder() {
            return reminder;
        }

        public void setReminder(String reminder) {
            this.reminder = reminder;
        }
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
}
