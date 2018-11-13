package com.service.letinvr.letinservice.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.service.letinvr.letinservice.R;
import com.service.letinvr.letinservice.service.ServiceOne;
import com.service.letinvr.letinservice.service.ServiceTwo;
import com.service.letinvr.letinservice.utlis.StatusBarUtil;
import com.service.letinvr.letinservice.view.CustomVideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CustomVideoView videoView;
    private ImageView mImg;
    private TextView mTx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            StatusBarUtil.setStatusBarColor(this, R.color.transparent);
        }
        getReceWindow();//透明白色字体
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.mCustomVideoVide);
        mImg = findViewById(R.id.mImg);
        mTx = findViewById(R.id.mTx);
        initView();//初始化View
        initService();//开启服务
        try {
            mTx.setText(getVersionName(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.end, Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * 得到当前应用版本名称的方法
     *
     * @param context :上下文
     * @throws Exception
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
        startService(new Intent(this, ServiceOne.class));
        startService(new Intent(this, ServiceTwo.class));
    }

    public void initView() {//设置动态背景
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

    private void getReceWindow() {
        //实现状态栏图标和文字颜色为浅色
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().getDecorView().findViewById(android.R.id.content).setPadding(0, 0, 0, 0);

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
    protected void onRestart() {
        initView();
        super.onRestart();
    }

    @Override
    protected void onStop() {
        videoView.stopPlayback();
        super.onStop();
    }


}
