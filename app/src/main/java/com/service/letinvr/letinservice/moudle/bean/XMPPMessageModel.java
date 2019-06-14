package com.service.letinvr.letinservice.moudle.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class XMPPMessageModel {

    @SerializedName("action")
    private String action;
    @SerializedName("functionType")
    private String functionType;
    @SerializedName("delay")
    private String delay;
    @SerializedName("platform")
    private String platform;
    @SerializedName("isVR")
    private int isVR;
    @SerializedName("trickplayMode")
    private int trickplayMode;
    @SerializedName("seekPostion")
    private int seekPostion;
    @SerializedName("fastSpeed")
    private int fastSpeed;
    @SerializedName("rot")
    private String rot;
    @SerializedName("mediaCode")
    private String mediaCode;
    @SerializedName("mediaType")
    private String mediaType;
    @SerializedName("userID")
    private String userID;
    @SerializedName("playByBookMark")
    private String playByBookMark;
    @SerializedName("playByTime")
    private String playByTime;
    @SerializedName("playUrl")
    private String playUrl;
    @SerializedName("actionSource")
    private String actionSource;
    @SerializedName("videoType")
    private String videoType;
    private static Gson gson = new Gson();
    public static final int XMPP_MESSAGE_IS_VR = 1;
    public static final int XMPP_MESSAGE_NOT_VR = 0;
    public static final String MSG_FUNCTION_TYPE_START = "startPlay";
    public static final String MSG_FUNCTION_TYPE_OPENVRSTB = "openVRSTB";
    public static final String MSG_FUNCTION_TYPE_TRICK_CONTROL = "trickPlayControl";

    public static XMPPMessageModel parseData(String data) {
        return (XMPPMessageModel) gson.fromJson(data, XMPPMessageModel.class);
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFunctionType() {
        return this.functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getDelay() {
        return this.delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getIsVR() {
        return this.isVR;
    }

    public void setIsVR(int isVR) {
        this.isVR = isVR;
    }

    public int getTrickplayMode() {
        return this.trickplayMode;
    }

    public void setTrickplayMode(int trickplayMode) {
        this.trickplayMode = trickplayMode;
    }

    public int getSeekPostion() {
        return this.seekPostion;
    }

    public void setSeekPostion(int seekPostion) {
        this.seekPostion = seekPostion;
    }

    public int getFastSpeed() {
        return this.fastSpeed;
    }

    public void setFastSpeed(int fastSpeed) {
        this.fastSpeed = fastSpeed;
    }

    public String getRot() {
        return this.rot;
    }

    public void setRot(String rot) {
        this.rot = rot;
    }

    public String getMediaCode() {
        return this.mediaCode;
    }

    public void setMediaCode(String mediaCode) {
        this.mediaCode = mediaCode;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPlayByBookMark() {
        return this.playByBookMark;
    }

    public void setPlayByBookMark(String playByBookMark) {
        this.playByBookMark = playByBookMark;
    }

    public String getPlayByTime() {
        return this.playByTime;
    }

    public void setPlayByTime(String playByTime) {
        this.playByTime = playByTime;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getActionSource() {
        return this.actionSource;
    }

    public void setActionSource(String actionSource) {
        this.actionSource = actionSource;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public static String toJsonString(XMPPMessageModel messageModel) {
        return gson.toJson(messageModel);
    }

    public String toString() {
        return "XMPPMessageModel{action='" + this.action + '\'' + ", functionType='" + this.functionType + '\'' + ", delay='" + this.delay + '\'' + ", platform='" + this.platform + '\'' + ", isVR=" + this.isVR + ", trickplayMode=" + this.trickplayMode + ", seekPostion=" + this.seekPostion + ", fastSpeed=" + this.fastSpeed + ", rot='" + this.rot + '\'' + ", mediaCode='" + this.mediaCode + '\'' + ", mediaType='" + this.mediaType + '\'' + ", userID='" + this.userID + '\'' + ", playByBookMark='" + this.playByBookMark + '\'' + ", playByTime='" + this.playByTime + '\'' + ", playUrl='" + this.playUrl + '\'' + ", actionSource='" + this.actionSource + '\'' + ", videoType='" + this.videoType + '\'' + '}';
    }
}
