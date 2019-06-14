package com.service.letinvr.letinservice.ui;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.service.letinvr.letinservice.R;
import com.service.letinvr.letinservice.api.Constant;
import com.service.letinvr.letinservice.base.BaseActivity;
import com.service.letinvr.letinservice.service.LetinServer;
import com.service.letinvr.letinservice.service.LetinServers;
import com.service.letinvr.letinservice.utlis.LogToFile;
import com.service.letinvr.letinservice.utlis.MacUtils;
import com.service.letinvr.letinservice.utlis.SPUtils;
import com.service.letinvr.letinservice.view.CustomVideoView;

import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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

/***********************************************************
 *                                                         *
 * You may think you know what the following code does.    *
 * But you dont. Trust me.                                 *
 * Fiddle with it, and youll spend many a sleepless        *
 * night cursing the moment you thought youd be clever     *
 * enough to "optimize" the code below.                    *
 * Now close this file and go play with something else.    *
 *                                                         *
 ***********************************************************/

public class MainActivity extends BaseActivity {
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS};
    private CustomVideoView videoView;
    private ImageView mImg;
    private TextView mTx;
    private int REQUEST_PERMISSION_CODE = 1;
    private boolean files = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        videoView = findViewById(R.id.mCustomVideoVide);
        mImg = findViewById(R.id.mImg);
        mTx = findViewById(R.id.mTx);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);

            } else {

                File file = new File(Constant.path, "Config.int");
                if (!file.exists()) {
                    LogToFile.e("Srz_    --->  初始写入文件");
                    Constant.writeToFile("0", "", "", "");
                }
                initService();
            }
        } else {
            initService();//开启服务
        }
        initViews();//初始化View

        try {
            mTx.setText("V" + getVersionName(this));
        } catch (Exception e) {
        }
        String mac = MacUtils.getMac(this);
        LogToFile.e("Srz_    --->   " + mac.replace(":", "-"));

        LogToFile.e("Srz  ---> 网络状态 " + isNetworkAvailable(this)+" ,IP = "+ getLocalIp());


    }
    // 获取有限网IP
    private static String getLocalIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {

        }
        return "0.0.0.0";

    }


    /**
     * 得到当前应用版本名称的方法
     *
     * @param context :上下文
     */
    public static String getVersionName(Context context) throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名
        PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }

    private void initService() {//启动Service
        startService(new Intent(this, LetinServer.class));
        startService(new Intent(this, LetinServers.class));
    }

    public void initViews() {//设置动态背景
        //设置播放加载路径
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.index_background));
        //播放
        videoView.start();
        //循环播放
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

    }

    //上下文           完整包+类名
    public static boolean isServiceWorked(Context context, String serviceName) {
        ActivityManager myManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> runningService =
                (ArrayList<ActivityManager.RunningServiceInfo>)
                        myManager.getRunningServices(Integer.MAX_VALUE);
        for (int i = 0; i < runningService.size(); i++) {
            if (runningService.get(i).service.getClassName().toString().equals(serviceName)) {
                return true;//false 没有运行 true 正在运行
            }
        }
        return false;
    }

    @Override
    protected void onStop() {
        videoView.stopPlayback();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        initService();
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        files = (boolean) SPUtils.get(MainActivity.this, "files", files);
        if (files = true) {
            files = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                LogToFile.e("MainActivity" + ",申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
            Constant.writeToFile("0", "", "", "");
            initService();
        }

    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     *
     * @param context Context
     * @return true 表示网络可用
     */
    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }//blocked
        }
        return false;
    }
}
