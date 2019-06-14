package com.service.letinvr.letinservice.service;


//
//                    .::::.
//                  .::::::::.
//                 :::::::::::  FUCK YOU
//             ..:::::::::::'
//           '::::::::::::'
//             .::::::::::
//        '::::::::::::::..
//             ..::::::::::::.
//           ``::::::::::::::::
//            ::::``:::::::::'        .:::.
//           ::::'   ':::::'       .::::::::.
//         .::::'      ::::     .:::::::'::::.
//        .:::'       :::::  .:::::::::' ':::::.
//       .::'        :::::.:::::::::'      ':::::.
//      .::'         ::::::::::::::'         ``::::.
//  ...:::           ::::::::::::'              ``::.
// ```` ':.          ':::::::::'                  ::::..
//                    '.:::::'                    ':'````..

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.easier.xmpp.XMPPConnectUtil;
import com.google.gson.Gson;
import com.service.letinvr.letinservice.api.API;
import com.service.letinvr.letinservice.api.BaseUrl;
import com.service.letinvr.letinservice.api.Constant;
import com.service.letinvr.letinservice.api.PresenterConstant;
import com.service.letinvr.letinservice.api.TranformJson;
import com.service.letinvr.letinservice.broadcast.AccountBroadcastReceiver;
import com.service.letinvr.letinservice.broadcast.NetWorkChangReceiver;
import com.service.letinvr.letinservice.contract.LetinContract;
import com.service.letinvr.letinservice.moudle.bean.XMPPMessageModel;
import com.service.letinvr.letinservice.moudle.bean.authorization.QueryAuthorizationReturn;
import com.service.letinvr.letinservice.moudle.bean.authorization.QueryAuthorizationReturnRoot;
import com.service.letinvr.letinservice.moudle.bean.bindauthorization.UnBindReturn;
import com.service.letinvr.letinservice.moudle.bean.bindtv.QueryBindTVListReturn;
import com.service.letinvr.letinservice.moudle.bean.getverifycode.GetVerifyCodeReturn;
import com.service.letinvr.letinservice.moudle.bean.verifycode.QueryVerifyCodeReturn;
import com.service.letinvr.letinservice.moudle.bean.verifycode.QueryVerifyCodeRoot;
import com.service.letinvr.letinservice.moudle.hvsdate.HeartBsatReturn;
import com.service.letinvr.letinservice.moudle.hvsdate.LoginRouteReturn;
import com.service.letinvr.letinservice.moudle.hvsdate.SessionIDDate;
import com.service.letinvr.letinservice.presenter.LetinPresenter;
import com.service.letinvr.letinservice.ui.MainActivity;
import com.service.letinvr.letinservice.utlis.AESUtils;
import com.service.letinvr.letinservice.utlis.LogToFile;
import com.service.letinvr.letinservice.utlis.MacUtils;
import com.service.letinvr.letinservice.utlis.SPUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import static com.service.letinvr.letinservice.api.API.SERVICE_TWO;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_101;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_102;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_103;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_104;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_105;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_106;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_107;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_108;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_109;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_110;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_111;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_112;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_113;
import static com.service.letinvr.letinservice.api.PresenterConstant.POST_CODE_114;

/***********************************************************
 *                                                         *
 * You may think you know what the following code does.    *
 * But you dont. Trust me.                                 *
 * Fiddle with it, and youll spend many a sleepless        *
 * night cursing the moment you thought youd be clever     *
 * enough to "optimize" the code below.                    *
 * Now close this file and go play with something else.    *
 *                                                         *
 *              2018/11/13 16:44                           *
 ***********************************************************/

public class LetinServer extends Service implements LetinContract.View {


    private LetinContract.Presenter mPresenter;
    private static final long TotalTime = 60 * 1000;
    private int Intervals = 0;
    private QueryVerifyCodeReturn queryVerifyCodeReturn;
    private QueryVerifyCodeRoot verifyCodeRoot;
    private QueryAuthorizationReturn authorization;
    private QueryAuthorizationReturnRoot returnRoots;
    private QueryBindTVListReturn bindTVListReturn;
    private GetVerifyCodeReturn codeReturn;
    private UnBindReturn unBindReturn;
    private HeartBsatReturn heartBsatReturn;
    private SessionIDDate usersessionIDDate1;
    private LoginRouteReturn userloginRouteReturn2;
    private LoginRouteReturn touristloginRouteReturn;
    private SessionIDDate touristsessionIDDate;
    private static Handler mHandler = new Handler(Looper.myLooper());
    private AccountBroadcastReceiver broadcastReceiver;
    private NetWorkChangReceiver netWorkChangReceiver;
    private int loginMax =0;
    //接收其他应用发来广播
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //接收其他应用广播
            if (!action.isEmpty() && action.equals(API.ACTION_SERVER_MESSAGE_SEND)) {
                String message = intent.getStringExtra("message");

                switch (message) {
                    case "Authorize"://获取授权关系
                        LogToFile.e("Srz ---> 获取授权关系  ");
                        getVrRootResult();
                        break;
                    case "VerificationCode"://获取验证码
                        LogToFile.e("Srz ---> 获取验证码  ");
                        obtainAuthorizationVerificationCode();
                        break;
                    case "BindTV"://获取绑定机顶盒
                        LogToFile.e("Srz ---> 获取绑定机顶盒  ");
                        queryBindTVList();
                        break;
                    case "LoginOut"://退出
                        LogToFile.e("Srz ---> 退出  ");
                        unbind();
                        break;
                    case "postRequest"://post
                        String postUrl = intent.getStringExtra(Constant.ACTION_POST_URL);
                        String postJson = intent.getStringExtra(Constant.ACTION_POST_JSON);
                        String postCookie = intent.getStringExtra(Constant.ACTION_POST_COOKIE);
                        LogToFile.e("Srz ---> post请求  " + postUrl + "\n" + postJson + "\n" + postCookie);
                        postHttpRequest(postUrl, postJson, postCookie);
                        break;
                }
            } else if (Constant.ACTION_LETIN_WIFI.equals(intent.getAction())) {
                LogToFile.e("Srz ---> 有网络  ");

                if (Constant.readFileContent(1).contains("=0")) {
                    LogToFile.e("Srz ---> 有网络 并且没有认证 HVS游客登录  ");
                    hvsTouristLogin();
                } else if (Constant.readFileContent(1).contains("=1")) {
                    LogToFile.e("Srz ---> 用户登录  ");
                    hvsUserLogin();
                    mHandler.post(mAuthorize);
                }
            } else if (API.ACTION_SERVER_MESSAGE.equals(intent.getAction())) {
                LogToFile.e("Srz ---> 本身发送消息  " + intent.getStringExtra("unityMsg"));
            } else if (Constant.ACTION_LANTING_MESSAGE.equals(intent.getAction())) {

                LogToFile.e("Srz --->  XMPP消息 " + intent.getStringExtra(Constant.SEND_XMPP_MSG) + "\n" + intent.getStringExtra(Constant.SEND_XMPP_TV));
                sendXMPPMsg(intent.getStringExtra(Constant.SEND_XMPP_MSG), intent.getStringExtra(Constant.SEND_XMPP_TV));

            }


        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPresenter = new LetinPresenter(this);//实例化
        initBroadcast();
        thread.start();
    }


    private void initBroadcast() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(API.ACTION_SERVER_MESSAGE_SEND);//其他应用
        filter.addAction(Constant.ACTION_LETIN_WIFI);
        filter.addAction(API.ACTION_SERVER_MESSAGE);
        filter.addAction(Constant.ACTION_LANTING_MESSAGE);
        registerReceiver(receiver, filter);

        broadcastReceiver = new AccountBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.ACTION_LOG_XMPP);
        intentFilter.addAction(Constant.ACTION_ACCEPT_XMPP);
        intentFilter.addAction(Constant.ACTION_DPVR_LAUNCHER_XMPP);
        intentFilter.addAction(Constant.ACTION_LANTING_MESSAGE);
        intentFilter.addAction(Constant.ACTION_MSG);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);

        netWorkChangReceiver = new NetWorkChangReceiver();
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter1.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter1.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkChangReceiver, filter1);
    }

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    boolean b = MainActivity.isServiceWorked(LetinServer.this, SERVICE_TWO);

                    if (!b) {
                        Intent service = new Intent(LetinServer.this, LetinServers.class);
                        startService(service);
                    }
                }
            };
            timer.schedule(task, 0, 3 * 60 * 1000);
        }
    });

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        // 重启自己
        unregisterReceiver(receiver);
        unregisterReceiver(broadcastReceiver);
        unregisterReceiver(netWorkChangReceiver);
        Intent intent = new Intent(getApplicationContext(), LetinServer.class);
        startService(intent);
        super.onDestroy();
    }

    //传给Unity层消息
    public void sendUnityMsg(Context context, final String msg) {
        LogToFile.e("Srz ---> 发送Unity 消息 " + msg);
        Intent intent = new Intent();
        intent.setAction(API.ACTION_SERVER_MESSAGE);
        intent.putExtra("unityMsg", msg);
        context.sendBroadcast(intent);
    }

    @Override
    public void setResult(String returnResult, int index) {
        switch (index) {
            case POST_CODE_101://y游客登录
                touristloginRouteReturn = new Gson().fromJson(returnResult, LoginRouteReturn.class);
                LoginRouteReturn.ResultBean result = touristloginRouteReturn.getResult();
                if (result.getRetCode().equals("000000000")) {
                    PresenterConstant.putKey(BaseUrl.VSP_HTTPS_URL, touristloginRouteReturn.getVspHttpsURL());
                    PresenterConstant.putKey(BaseUrl.VSP_URL, touristloginRouteReturn.getVspURL());
                    //写入游客登录状态 调度地址
                    Constant.writeToFile("0", "", touristloginRouteReturn.getVspHttpsURL(), "");
                    hvsTouristCertification();//游客认证

                }
                break;
            case POST_CODE_102://游客认证
                touristsessionIDDate = new Gson().fromJson(returnResult, SessionIDDate.class);
                if (touristsessionIDDate.getResult().getRetCode().equals("000000000")) {
                    PresenterConstant.putKey(Constant.JSESSIONID, touristsessionIDDate.getJSessionID());
                    //写入游客认证状态 游客seesion  游客调度接口
                    PresenterConstant.putKey("loginKey", touristsessionIDDate.getSubnetID());
                    Constant.writeToFile("0", touristsessionIDDate.getJSessionID(), PresenterConstant.getKey(BaseUrl.VSP_HTTPS_URL), "");
//                  //启动游客心跳线程
                    mHandler.post(HVSHeartbeatThread);
                }
                break;
            case POST_CODE_103://获取授权关系
                authorization = new Gson().fromJson(returnResult, QueryAuthorizationReturn.class);
                if (authorization.getReturnCode() == 2) {
                    //未授权 获取授权验证码
                    LogToFile.e("Srz --->  授权关系 未授权 获取验证码 " + returnResult);
                    obtainAuthorizationVerificationCode();
                } else if (authorization.getReturnCode() == 0) {


                    sendUnityMsg(LetinServer.this, "BM_VR&PhoneAuthorize|true");
                    //已授权
                    LogToFile.e("Srz --->  授权关系 已授权  " + returnResult);
                    returnRoots = new Gson().fromJson(returnResult, QueryAuthorizationReturnRoot.class);//设置数据
                    String xmppAddress = authorization.getXmppAddress();//获取返回的 ip和端口
                    String xmppIP = xmppAddress.substring(0, xmppAddress.indexOf(":"));
                    String xmppPort = xmppAddress.substring(xmppAddress.indexOf(":") + 1);

                    //保存XMPP IP port
                    PresenterConstant.putKey(Constant.XMPP_IP, xmppIP);
                    PresenterConstant.putKey(Constant.XMPP_PORT, xmppPort);
                    PresenterConstant.putKey(Constant.XMPP_ADDRESS, returnRoots.getXmppAddress());//保存xmpp地址
                    PresenterConstant.putKey(Constant.MTV_ACCOUNT, returnRoots.getMtvAccount());//保存mtv账号
                    queryBindTVList();//查询绑定TV信息


                } else if (authorization.getReturnCode() == 1) {
                    LogToFile.e("Srz --->   查询授权关系 错误 " + authorization.getErrorMessage());
                    Constant.errorCodes(String.valueOf(authorization.getErrorCode()), authorization.getErrorMessage());
                }
                break;
            case POST_CODE_104://获取授权验证码

                //返回验证码
                codeReturn = new Gson().fromJson(returnResult, GetVerifyCodeReturn.class);
                if (codeReturn.getReturnCode() == 0) {
                    PresenterConstant.putKey(Constant.VERIFY_CODE, codeReturn.getVerifyCode());
                    LogToFile.e("Srz --->  授权验证码：" + codeReturn.getVerifyCode());
                    sendUnityMsg(LetinServer.this, "BM_VerificationCode|" + codeReturn.getVerifyCode());//发送授权验证码
                    //回传Unity验证码
                    pollingVerificationCode();

                } else {
                    Constant.errorCodes(String.valueOf(codeReturn.getErrorCode()), codeReturn.getErrorMessage());
                    LogToFile.e("Srz --->  获取授权验证码错误 " + codeReturn.getErrorMessage());
                }
                break;
            case POST_CODE_105://轮询授权结果
                queryVerifyCodeReturn = new Gson().fromJson(returnResult, QueryVerifyCodeReturn.class);
                if (queryVerifyCodeReturn.getReturnCode() == 0) {
                    if (queryVerifyCodeReturn.getStatus().equals("0")) {
                        LogToFile.e("Srz --->  轮询验证码状态 未授权" + returnResult);
                        sendUnityMsg(LetinServer.this, "BM_Authorize|false");
                        //开启轮询
                        if (Intervals == 0) {
                            Intervals = Integer.parseInt(queryVerifyCodeReturn.getInterval());
                            mHandler.post(CodeThread);
                        }


                    } else if (queryVerifyCodeReturn.getStatus().equals("1")) {
                        LogToFile.e("Srz_    --->  轮询验证码状态 已授权 " + returnResult);
                        sendUnityMsg(LetinServer.this, "BM_Authorize|ture");
                        verifyCodeRoot = new Gson().fromJson(returnResult, QueryVerifyCodeRoot.class);
                        PresenterConstant.putKey(Constant.STATUS, verifyCodeRoot.getStatus());//保存授权状态

                        String XMPP_ACC_PWD = AESUtils.decryptAES(verifyCodeRoot.getXmppAccountPwd(), PresenterConstant.KEY);
                        String ACCOUNT_PWD = AESUtils.decryptAES(verifyCodeRoot.getAccountPwd(), PresenterConstant.KEY);

                        PresenterConstant.putKey(Constant.ACCOUNT_PWD, verifyCodeRoot.getAccountPwd());
                        PresenterConstant.putKey(Constant.STATUS, queryVerifyCodeReturn.getStatus());
                        PresenterConstant.putKey(Constant.USER_ID, ACCOUNT_PWD.substring(0, 12));//保存HVS所需账号
                        PresenterConstant.putKey(Constant.CLIENT_PASSWD, ACCOUNT_PWD.substring(12));//保存HVS所需密码
                        PresenterConstant.putKey(Constant.XMPP_ACCOUNT, XMPP_ACC_PWD.substring(0, 12));//XMPP启动账号
                        PresenterConstant.putKey(Constant.XMPP_PWD, XMPP_ACC_PWD.substring(12));//XMPP启动密码
                        //写入已授权 状态 写入之前保存的游客Session调度地址 HVS账号
                        mHandler.removeCallbacks(CodeThread);//移除轮询验证码定时器
                        getVrRootResult();//查询授权关系


                    } else if (queryVerifyCodeReturn.getStatus().equals("2")) {
                        LogToFile.e("Srz --->   验证码过期");
                        sendUnityMsg(LetinServer.this, "BM_Authorize|Expired");
                        mHandler.removeCallbacks(CodeThread);
                        //回传Unity 验证码过期
                    }
                } else {
                    LogToFile.e("Srz ---> 轮询验证码授权结果 错误  " + returnResult);
                    Constant.errorCodes(String.valueOf(queryVerifyCodeReturn.getErrorCode()), queryVerifyCodeReturn.getErrorMessage());
                }
                break;
            case POST_CODE_106://查询绑定机顶盒信息
                LogToFile.e("Srz_    ---> 查询绑定机顶盒信息 " + returnResult);
                bindTVListReturn = new Gson().fromJson(returnResult, QueryBindTVListReturn.class);

                if (bindTVListReturn.getReturnCode() == 0) {
                    LogToFile.e("Srz ---> 查询绑定机顶盒成功  " + returnResult);
                    sendUnityMsg(LetinServer.this, "bindTVList|" + returnResult);
                    if (Constant.readFileContent(1).contains("=0")) {
                        LogToFile.e("Srz ---> 用户登录调度  ");
                        hvsUserLogin();//用户登录调度
                    }

                } else {
                    LogToFile.e("Srz ---> 查询绑定机顶盒失败  " + returnResult);
                    Constant.errorCodes(String.valueOf(bindTVListReturn.getErrorCode()), bindTVListReturn.getErrorMessage());
                }
                break;
            case POST_CODE_107://解绑结果
                LogToFile.e("Srz_    ---> setResult  5," + returnResult);
                unBindReturn = new Gson().fromJson(returnResult, UnBindReturn.class);
                if (unBindReturn.getReturnCode() == 0) {
                    LogToFile.e("Srz --->   八闽视频解绑成功" + returnResult);
                } else {
                    LogToFile.e("Srz ---> 八闽视频解绑失败  " + returnResult);
                    Constant.errorCodes(String.valueOf(unBindReturn.getErrorCode()), unBindReturn.getErrorMessage());
                }
                break;
            case POST_CODE_108://用户登录調度结果
                LogToFile.e("Srz ---> 用户登录调度结果  ");
                userloginRouteReturn2 = new Gson().fromJson(returnResult, LoginRouteReturn.class);
                LoginRouteReturn.ResultBean result2 = userloginRouteReturn2.getResult();
                if (result2.getRetCode().equals("000000000")) {
                    LogToFile.e("Srz_    ---> RetMsg  " + result2.getRetMsg());
                    PresenterConstant.putKey(BaseUrl.VSP_HTTPS_URL, userloginRouteReturn2.getVspHttpsURL());
                    PresenterConstant.putKey(BaseUrl.VSP_URL, userloginRouteReturn2.getVspURL());

                    Constant.writeToFile(PresenterConstant.getKey(Constant.STATUS), PresenterConstant.getKey(Constant.JSESSIONID),
                            userloginRouteReturn2.getVspHttpsURL(), PresenterConstant.getKey(Constant.ACCOUNT_PWD));
                    hvsUserAuthentication();
                }
                break;
            case POST_CODE_109://用户认证结果
                usersessionIDDate1 = new Gson().fromJson(returnResult, SessionIDDate.class);
                LogToFile.e("Srz ---> 用户认证  " + returnResult);
                String retCode = usersessionIDDate1.getResult().getRetCode();
                if (retCode.equals("000000000")) {
                    PresenterConstant.putKey(Constant.JSESSIONID, usersessionIDDate1.getJSessionID());

                    PresenterConstant.putKey("loginKey", usersessionIDDate1.getSubnetID());
                    Constant.writeToFile(PresenterConstant.getKey(Constant.STATUS), PresenterConstant.getKey(Constant.JSESSIONID),
                            PresenterConstant.getKey(BaseUrl.VSP_HTTPS_URL), PresenterConstant.getKey(Constant.ACCOUNT_PWD));
                    initXMPP();
                    mHandler.post(HVSHeartbeatThread);
                    mHandler.post(mAuthorize);
                    sendUnityMsg(LetinServer.this, "HVSLogin|Success");
                    postEPG();

                } else {
                    LogToFile.e("Srz ---> HVSLogin失败  "+returnResult);
                    sendUnityMsg(LetinServer.this, "HVSLogin|Flunk");
                    if (loginMax!=3){
                        LogToFile.e("Srz  ---> 登录失败次数 "+loginMax);
                        loginMax++;
                        hvsUserAuthentication();
                    }else {
                        unbind();
                    }
                }
                break;
            case POST_CODE_110://心跳结果
                heartBsatReturn = new Gson().fromJson(returnResult, HeartBsatReturn.class);
                HeartBsatReturn.ResultBean result1 = heartBsatReturn.getResult();
                if (result1.getRetCode().equals("000000000")) {
                    LogToFile.e("Srz_    --->  HVS心跳 " + result1.getRetMsg());

                }

                break;
            case POST_CODE_111://HVS退出结果
                //退出HVS时要调用游客登录
                sendUnityMsg(LetinServer.this, "HVSLoginOut|true");

                break;
            case POST_CODE_112:
                authorization = new Gson().fromJson(returnResult, QueryAuthorizationReturn.class);
                if (authorization.getReturnCode() == 2) {
                    //未授权 获取授权验证码
                    //告诉Unity 未授权
                    LogToFile.e("Srz ---> 手机端已解除绑定  ");
                    Intervals = 0;
                    mHandler.removeCallbacks(mAuthorize);
                    mHandler.removeCallbacks(mRunnable);
                    mHandler.removeCallbacks(HVSHeartbeatThread);
                    hvsLogOut();//退出HVS 并登录游客
                    //占位行  退出EPG
                    closeXMPPConnect();

                    hvsTouristLogin();//游客登录
                    SPUtils.clear(LetinServer.this);//清除本地缓存
                    sendUnityMsg(LetinServer.this, "BM_PhoneAuthorize|false");
                } else if (authorization.getReturnCode() == 0) {
                    sendUnityMsg(LetinServer.this, "BM_PhoneAuthorize|true");
                    LogToFile.e("Srz ---> 已绑定  ");


                } else if (authorization.getReturnCode() == 1) {
                    LogToFile.e("Srz --->   错误 " + authorization.getErrorMessage());

                }
                break;
            case POST_CODE_113:
                LogToFile.e("Srz  ---> post请求结果 "+returnResult);
                sendUnityMsg(LetinServer.this, "PostResult|" + returnResult);
                break;
            case POST_CODE_114:

                LogToFile.e("Srz_    ---> EPG_Login  " + returnResult);
                //v-resp_desc : "No mobile Unauthorised"
                break;
        }


    }
    @Override
    public void showMessage(String errorMsg, int index) {
        switch (index){
            case POST_CODE_113:
                sendUnityMsg(LetinServer.this, "PostError|" + errorMsg);
                break;
        }
    }

    private void closeXMPPConnect() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                XMPPConnectUtil.getInstance().closeXMPPConnect();
            }
        });
    }


    @Override
    public void setPresenter(LetinContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    public void getVrRootResult() {
        //获取手机与一体机授权关系
        String vrRootResult = TranformJson.getVrRootResult();
        mPresenter.start(BaseUrl.QUERY_AUTHORIZATION_REL, vrRootResult, "", POST_CODE_103);
    }

    public void pollVrRootResult() {
        //获取手机与一体机授权关系
        String vrRootResult = TranformJson.getVrRootResult();

        mPresenter.start(BaseUrl.QUERY_AUTHORIZATION_REL, vrRootResult, "", POST_CODE_112);
    }

    public void obtainAuthorizationVerificationCode() {
        //获取授权验证码
        String obAht = TranformJson.obtainAuthorizationVerificationCode();
        mPresenter.start(BaseUrl.GET_VERIFY_CODE, obAht, "", POST_CODE_104);
    }

    public void pollingVerificationCode() {
        TranformJson.codeReturn = codeReturn;

        String pollVerCode = TranformJson.pollingVerificationCode();
        mPresenter.start(BaseUrl.QUERY_VERIFY_CODE, pollVerCode, "", POST_CODE_105);
    }

    public void queryBindTVList() {
        //查询绑定机顶盒信息
        String bindTvLis = TranformJson.queryBindTVList();
        mPresenter.start(BaseUrl.QUERY_BIND_TVLIST, bindTvLis, "", POST_CODE_106);
    }

    public void unbind() {
        //解除绑定
        String unbindJson = TranformJson.unbind();
        mPresenter.start(BaseUrl.UNBIND_AUTHORIZATION_REL, unbindJson, "", POST_CODE_107);
        hvsLogOut();//退出HVS 并登录游客
        mHandler.removeCallbacks(mRunnable);
        mHandler.removeCallbacks(CodeThread);
        mHandler.removeCallbacks(HVSHeartbeatThread);
        Intervals = 0;
        //占位行  退出EPG
        closeXMPPConnect();
        SPUtils.clear(LetinServer.this);//清除本地缓存
        hvsTouristLogin();//游客登录


    }

    public void hvsTouristLogin() {//游客登录
        String loginJson = "{\"subscriberID\":\"guestid\"}";
        mPresenter.start(BaseUrl.HTTPS, loginJson, "", POST_CODE_101);
    }

    public void hvsUserLogin() {//用户登录
        hvsLogOut();//退出游客
        String loginJson;
        String userId = PresenterConstant.getKey(Constant.MTV_ACCOUNT);
        LogToFile.e("Srz ---> userId  " + userId);
        try {
            loginJson = new JSONObject("{subscriberID:" + userId + "}").toString();
            LogToFile.e("Srz --->   " + loginJson);
            mPresenter.start(BaseUrl.HTTPS, loginJson, "", POST_CODE_108);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void hvsTouristCertification() {//游客认证

        mPresenter.start(PresenterConstant.getKey(BaseUrl.VSP_HTTPS_URL) + BaseUrl.VSP_V3_AUTHENTICATE, BaseUrl.VAP_PARAS, "", POST_CODE_102);
    }

    public void hvsUserAuthentication() {//用户认证

        String uahst = "{\"authenticateBasic\":{\"userID\":\""
                + PresenterConstant.getKey(Constant.MTV_ACCOUNT)
                + "\",\"userType\":0,\"clientPasswd\":\""
                + PresenterConstant.getKey(Constant.CLIENT_PASSWD)
                + "\",\"extensionFields\":[{\"key\":\"clientID\",\"values\":[\"AndroidPhone\"]}]},\"authenticateDevice\":{\"deviceModel\":\"AndroidPhone\",\"physicalDeviceID\":"
                + "\"" + PresenterConstant.getKey(Constant.MTV_ACCOUNT) + Constant.getMAC() + "\"}}";
        mPresenter.start(PresenterConstant.getKey(BaseUrl.VSP_HTTPS_URL) + BaseUrl.VSP_V3_AUTHENTICATE, uahst, "", POST_CODE_109);
    }

    public void heartBeat() {//心跳
        mPresenter.start(PresenterConstant.getKey(BaseUrl.VSP_HTTPS_URL) + BaseUrl.VSP_V3_ONLINE_HEARTBEAT, "",
                Constant.JSESSIONID + PresenterConstant.getKey(Constant.JSESSIONID), POST_CODE_110);
    }

    public void hvsLogOut() {//用户/游客/退出登录

        if (Constant.readFileContent(1).contains("=0")) {//退出游客
            LogToFile.e("Srz ---> 退出游客  ");
            String key = PresenterConstant.getKey("loginKey");
            String postJosn = "{\"type\":0,\"physicalDeviceId\":\"" + key + Constant.getMAC() + "\"}";
            mPresenter.start(PresenterConstant.getKey(BaseUrl.VSP_HTTPS_URL) + BaseUrl.VSP_V3_LOGOUT, postJosn, "", POST_CODE_111);
        } else if (Constant.readFileContent(1).contains("=1")) {
            LogToFile.e("Srz ---> 退出用户  ");
            String key = PresenterConstant.getKey(Constant.MTV_ACCOUNT).substring(1);
            String postJosn = "{\"type\":1,\"physicalDeviceId\":\"" + key + Constant.getMAC() + "\"}";
            LogToFile.e("Srz_  退出用户登录  --->   " + postJosn);
            mPresenter.start(PresenterConstant.getKey(BaseUrl.VSP_HTTPS_URL) + BaseUrl.VSP_V3_LOGOUT, postJosn, "", POST_CODE_111);
        }

    }

    public void postHttpRequest(String url, String jsonDate, String cookie) {
        mPresenter.start(url, jsonDate, cookie, POST_CODE_113);
    }

    public void postEPG() {

        LogToFile.e("Srz_    --->  EPG 预留 ");

    }

    public void initXMPP() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                LogToFile.e("Srz_    --->  启动 xmpp 包名：" + LetinServer.this.getPackageName());
                XMPPConnectUtil.getInstance().startXMPPService(
                        LetinServer.this,
                        LetinServer.this.getPackageName(),
                        Constant.ACTION_LOG_XMPP,
                        Constant.ACTION_ACCEPT_XMPP,
                        PresenterConstant.getKey(Constant.XMPP_IP),
                        Integer.parseInt(PresenterConstant.getKey(Constant.XMPP_PORT)),
                        PresenterConstant.getKey(Constant.XMPP_ACCOUNT),
                        PresenterConstant.getKey(Constant.XMPP_PWD),
                        MacUtils.getMac(LetinServer.this).replace(":", ""));
            }
        });
        mHandler.post(mRunnable);

    }

    public  void sendXMPPMsg(final String xmppMsg, final String tvAccount) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (Constant.readFileContent(1).contains("=1")) {
                    XMPPMessageModel xmppMessageModel = XMPPMessageModel.parseData(xmppMsg);
                    String json = new Gson().toJson(xmppMessageModel);
                    LogToFile.e("Srz_    --->发送XMPP消息   " + json);
                    XMPPConnectUtil.getInstance().sendXMPPMessage(xmppMessageModel, tvAccount);
                }else {
                    sendUnityMsg(LetinServer.this,"XMPPError|Unbound");
                }
            }
        });

    }

    Runnable mAuthorize = new Runnable() {
        @Override
        public void run() {
            pollVrRootResult();//授权关系
            mHandler.postDelayed(this, 5000);
        }
    };
    Runnable CodeThread = new Runnable() {
        @Override
        public void run() {
            //轮询验证码
            pollingVerificationCode();
            mHandler.postDelayed(this, Intervals * 1000);
        }
    };
    Runnable HVSHeartbeatThread = new Runnable() {
        @Override
        public void run() {
            //心跳线程执行

            heartBeat();
            mHandler.postDelayed(this, TotalTime);
        }
    };
    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            LogToFile.e("Srz ---> XMPP心跳  ");
            XMPPConnectUtil.getInstance().sendXMPPMessage("SB.push.huawei", PresenterConstant.getKey(Constant.XMPP_ACCOUNT));
            mHandler.postDelayed(this, 5000);
        }
    };



}
