package com.service.letinvr.letinservice.api;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;


import com.service.letinvr.letinservice.app.APP;
import com.service.letinvr.letinservice.utlis.LogToFile;
import com.service.letinvr.letinservice.utlis.MacUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;


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
 * 2019/05/06 16:11 星期一
 **/
public class Constant {

    public static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/FJCMCCCloudVR/";

    public static final String ACTION_LOG_XMPP = "cn.itv.xmpp.test.log.action"; // XMPP自定义日志类的广播
    public static final String ACTION_ACCEPT_XMPP = "cn.itv.xmpp.test.accept.action"; //XMPP自定义接收消息广播

    public static final String ACTION_LANTING_MESSAGE = "com.picovr.lanting.message";
    public static final String ACTION_DPVR_LAUNCHER_XMPP = "com.dpvr.dpnlauncherXMPP";
    public static final String ACTION_MSG = "com.letinvr.MSG_XMPP_SEND";
    public static final String ACTION_qiut = "com.letinvr.qiut";
    public static final String ACTION_POLL_AUTHORIZATION = "com.letinvr.poll.authorization";//轮询授权
    public static final String ACTION_GET_CODE = "com.letinvr.get.code";//获取验证码
    public static final String ACTION_GET_CODE_STATUS = "com.letinvr.code.status";//获取验证码状态
    public static final String ACTION_GET_BIND_TV_LIST = "com.letinvr.get.bindTVList";//获取绑定机顶盒
    public static final String ACTION_HVS_LOGIN = "com.letinvr.HVS.Login";//hvs调度
    public static final String ACTION_HVS_LOGIN_AUTHENTICATE = "com.letinvr.HVS.Login_Authenticate";//hvs登录
    public static final String ACTION_HVS_HEARTBEAT = "com.letinvr.HVS.Login_eartbeat";//hvs心跳
    public static final String ACTION_HVS_LOGIN_OUT = "com.letinvr.HVS.Login_out";//hvs退出

    public static final String ACTION_POST_HTTP_REQUEST = "com.letin.post_httpRequest";
    public static final String ACTION_POST_URL = "url";
    public static final String ACTION_POST_JSON = "json";
    public static final String ACTION_POST_COOKIE = "cookie";
    public static final String ACTION_LETIN_WIFI = "com.letin.wifi";

    public static final String POLL_AUTHORIZATION = "pollingAuthorization";

    public static final String SEND_XMPP_MSG = "sendXMPPMsg";
    public static final String SEND_XMPP_TV = "sendTvAccount";


    private static boolean log = true;
    public static final String APPID = "appId";  //应用标识
    public static final String TIME_STAMP = "timestamp";  //请求时间戳
    public static final String TOKEN = "token";  //消息token
    public static final String VRID = "VRId";  //设备标识
    public static final String NAME = "name";  //设备昵称
    public static final String REQ_TYPE = "reqType";  //请求类型
    public static final String MTV_ACCOUNT = "mtvAccount";  //手机app账号//mtv账号

    public static final String SIGN = "sign";  //签名
    public static final String STATUS = "status";  //验证码状态
    public static final String INTERVA1 = "interva1";//定时调用间隔
    public static final String ACCOUNT_PWD = "accountPwd";  //mtv账号+密码，密文
    public static final String XMPP_ADDRESS = "xmppAddress";  //XMPP地址
    public static final String XMPP_ACCOUNT_PWD = "xmppAccountPwd";  //XMPP账号+密码，密文

    public static final String USER_ID = "userID";
    public static final String CLIENT_PASSWD = "clientPasswd";

    public static final String XMPP_IP = "xmpp_ip";
    public static final String XMPP_PORT = "xmpp_port";

    public static final String XMPP_PWD = "xmppPwd";  //手机xmpp密码
    public static final String XMPP_ACCOUNT = "xmppAccount";  //手机xmpp账号


    public static final String DATE = "data";  //结果数据
    public static final String TV_ACCOUNT = "tvAccount";  //tv机顶盒账号
    public static final String SIGNA_TURE = "signature";
    public static final String SHARE_FLAG = "shareFlag";


    public static final String RETURN_CODE = "returnCode";  //接口返回码
    public static final String ERROR_CODE = "errorCode";  //错误码
    public static final String ERROR_MESSAGE = "errorMessage";  //错误描述
    public static final String VERIFY_CODE = "verifyCode";  //验证码信息


    public static final String LETIN_MSG = "LetinMsg";
    public static final String LETIN_MSG_CALLBACK = "LetinOnReceiveCallback";

    /**
     * 通用错误码
     */
    public static final String ERROR_101 = "10101";  //系统内部异常
    public static final String ERROR_102 = "10102";   //请求参数列表为空
    public static final String ERROR_103 = "10103";   //参数为空
    public static final String ERROR_104 = "10104";   //参数值非法
    public static final String ERROR_105 = "10105";   //系统忙，请稍后再请求
    public static final String ERROR_106 = "10106";   //请求处理超时
    public static final String ERROR_107 = "10107";   //加解密错误
    public static final String ERROR_108 = "10108";   //参数格式错误
    /**
     * 消息验证错误码
     */
    public static final String ERROR_201 = "10201";   //请求平台非法
    public static final String ERROR_202 = "10202";   //请求URI非法
    public static final String ERROR_203 = "10203";     //消息请求超时
    public static final String ERROR_204 = "10204";     //token认证失败

    public static final String ERROR_0109 = "20109";    //账号不存在
    public static final String ERROR_0118 = "20118";  //已存在绑定关系//
    public static final String ERROR_0102 = "20102";    //验证码校验失败
    public static final String ERROR_0119 = "20119";//手机与VR不存在绑定关系
    /**
     * XMPP错误码
     */
    public static final String XMPP_ERROR_001 = "0601000001";   //消息语法/参数错误
    public static final String XMPP_ERROR_002 = "0601000002";   //访问鉴权失败
    public static final String XMPP_ERROR_003 = "0601000003";   //消息内容超大
    public static final String XMPP_ERROR_005 = "0601000005";   //主键冲突
    public static final String XMPP_ERROR_110 = "0601000110";   //账号已存在
    public static final String XMPP_ERROR_000 = "0601010000";   //通用服务器操作失败
    public static final String XMPP_ERROR_004 = "0601010004";   //消息队列异常
    public static final String XMPP_ERROR_10001 = "0601010001"; //系统服务不可用
    public static final String XMPP_ERROR_10002 = "0601010002"; //数据库异常
    public static final String XMPP_ERROR_10003 = "0601010003"; //系统过载

    /***
     * APP_BIND_STATE=0
     * JSESSIONID=01QVSMF0W8AICVS39UV2LC7RB5CK3TJ5
     * HVS_ADDRESS=https://112.50.234.120:33207
     * HVS_ACCOUNT=
     * @param errCode
     */

    /**
     * HVS
     */
    public static final String APP_BIND_STATE = "APP_BIND_STATE=";
    public static final String JSESSIONID = "JSESSIONID=";
    public static final String HVS_ADDRESS = "HVS_ADDRESS=";
    public static final String HVS_ACCOUNT = "HVS_ACCOUNT=";


    public static void writeToFile(String state, String ssion, String addres, String account) {

        String fileName = "Config.ini";
        String msg = APP_BIND_STATE + state + "\r\n" + JSESSIONID + ssion + "\r\n" + HVS_ADDRESS + addres + "\r\n" + HVS_ACCOUNT + account;

        makeFilePath(path, fileName);
        String absolutePath = path + fileName;

        File file = new File(absolutePath);
        if (!file.exists()) {
            Log.d("TestFile", "Create the file:" + absolutePath);
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;//FileOutputStream会自动调用底层的close()方法，不用关闭
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(file, false);//这里的第二个参数代表追加还是覆盖，true为追加，flase为覆盖
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(msg);

        } catch (FileNotFoundException e) {
            LogToFile.e("Srz --->   " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LogToFile.e("Srz --->   " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    scanFile(APP.getContext(), absolutePath);
                    bw.close();//关闭缓冲流
                }
            } catch (IOException e) {
                LogToFile.e("Srz --->   " + e.getMessage());
                e.printStackTrace();
            }
        }

    }

    //生成文件

    private static File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

//生成文件夹

    private static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e + "");
        }
    }

    public static void scanFile(Context context, String path) {
        Intent scanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        scanIntent.setData(Uri.fromFile(new File(path))); // DIR 替换为你想要刷新的目录
        context.sendBroadcast(scanIntent);
    }

    public static String readFileContent(int number) {
        File file = new File(Constant.path + "Config.ini");
        try {
            FileReader fileReader = new FileReader(file);
            LineNumberReader reader = new LineNumberReader(fileReader);
            String txt = "";
            int lines = 0;

            while (txt != null) {
                lines++;
                txt = reader.readLine();
                if (lines == number) {
                    return txt;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static void errorCodes(String errCode, String msg) {
        switch (errCode) {
            case ERROR_101:
                displayToastMsg(msg);
                break;
            case ERROR_102:
                displayToastMsg(msg);
                break;
            case ERROR_103:
                displayToastMsg(msg);
                break;
            case ERROR_104:
                displayToastMsg(msg);
                break;
            case ERROR_105:
                displayToastMsg(msg);
                break;
            case ERROR_106:
                displayToastMsg(msg);
                break;
            case ERROR_107:
                displayToastMsg(msg);
                break;
            case ERROR_108:
                displayToastMsg(msg);
                break;
            case ERROR_201:
                displayToastMsg(msg);
                break;
            case ERROR_202:
                displayToastMsg(msg);
                break;
            case ERROR_203:
                displayToastMsg(msg);
                break;
            case ERROR_204:
                displayToastMsg(msg);
                break;
            case ERROR_0109:
                displayToastMsg(msg);
                break;
            case ERROR_0119:
                displayToastMsg(msg);
                break;
            case ERROR_0102:
                displayToastMsg(msg);
                break;
            case ERROR_0118:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_001:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_002:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_003:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_005:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_110:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_000:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_004:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_10001:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_10002:
                displayToastMsg(msg);
                break;
            case XMPP_ERROR_10003:
                displayToastMsg(msg);
                break;

        }
    }

    public static void displayToastMsg(String msg) {
        if (log) {
            LogToFile.e("Srz_    ---> errorMsg:  " + msg);
        }

    }

    public static String getMAC() {
        String mac = MacUtils.getMac(APP.getContext());

        return mac.replace(":", "");
    }


}
