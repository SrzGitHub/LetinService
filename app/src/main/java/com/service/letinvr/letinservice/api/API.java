package com.service.letinvr.letinservice.api;

/**
 * 站在顶峰,看世界
 * 跌落谷底,思人生
 * 大姨夫 2018\10\20 0020
 **/
public class API {




    /**
     * 注意:机顶盒广播action为com.picovr.lanting.message
     * VR一体机发送广播action为com.picovr.xmpp.vr.business
     * VR一体机接收广播action为com.picovr.xmpp.vr.business.send
     */
    public static final String ACTION_LETIN_MESSAGE ="com.picovr.lanting.message";
    public static final String ACTION_XMPP_VR_BUSINESS ="com.picovr.xmpp.vr.business";
    public static final String ACTION_XMPP_VR_BUSINESS_SEND ="com.picovr.xmpp.vr.business.send";

    /**
     * 向其他应用发送广播
     * 接收其他应用广播
     */
    public static final String ACTION_SERVER_MESSAGE="com.letinvr.send.message";
    public static final String ACTION_SERVER_MESSAGE_SEND ="com.letinvr.send.message.send";


    public static final String SERVICE_TWO ="com.service.letinvr.letinservice.service.LetinServers";
    public static final String SERVICE_ONE ="com.service.letinvr.letinservice.service.LetinServer";

    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";//开机广播
    public static final String  ACTION_AUDIO_BECOMING_NOISY= "android.media.AUDIO_BECOMING_NOISY";//开机声音
    public static final String ACTION_SERVER_PACK_NAME = "com.service.letinvr.letinservice"; //包名

}
