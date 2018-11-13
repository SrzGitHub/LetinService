package com.service.letinvr.letinservice.api;

/**
 * 站在顶峰,看世界
 * 跌落谷底,思人生
 * 大姨夫 2018\10\20 0020
 **/
public class API {


    public static final String MESSAGE_ACTION = "com.service.MAIN_SERVICE_ACTION";

    //VR 应用接收的广播    LetinService广播监听 action
    public static final String RECEIVER_RADIO = "com.ShangHaiCT.LetinVR.ReceiveMessage";
    //VR 应用发送广播     VR应用广播监听action
    public static final String SEND_BROADCAST = "com.ShangHaiCT.LetinVR.SendMessage.LetinService";

    /**
     * 兰亭应用包名:
     * Launcher播放器:
     * 直播现场:
     * 全景视频:
     * 巨幕影院:
     * VR教育:
     */
    //  Launcher播放器
    public static final String LAUNCHER_PLAYER = "com.shct.vrVideoPlayer";
    //  直播现场
    public static final String LIVE_STREAMING = "com.shct.LiveStreaming";
    //  全景视频
    public static final String DEMAND_SYSTEM = "com.shct.DemandSystem";
    //  巨幕影院
    public static final String BIG_SCTREN = "com.shct.BigScreen";
    //  VR教育
    public static final String EDUCATTION_SYSTEM = "com.shct.EducationSystem";


    public static final String MESSAGER = "messager";//消息

    public static final String JSON = "json";//json

    public static final String DATE = "date";//数据
    public static final String HTTP = "http";//执行网络请求
    public static final String URL = "url";//请求地址


}
