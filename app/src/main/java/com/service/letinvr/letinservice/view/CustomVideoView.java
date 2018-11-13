package com.service.letinvr.letinservice.view;

//                           _ooOoo_
//                          o8888888o
//                          88" . "88
//                          (| -_- |)
//                          O\  =  /O
//                       ____/`---'\____
//                     .'  \\|     |//  `.
//                    /  \\|||  :  |||//  \
//                   /  _||||| -:- |||||-  \
//                   |   | \\\  -  /// |   |
//                   | \_|  ''\---/''  |   |
//                   \  .-\__  `-`  ___/-. /
//                 ___`. .'  /--.--\  `. . __
//              ."" '<  `.___\_<|>_/___.'  >'"".
//             | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//             \  \ `-.   \_ __\ /__ _/   .-` /  /
//        ======`-.____`-.___\_____/___.-`____.-'======
//                           `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      佛祖保佑       永无BUG
//
//              写这段代码的时候 只有我和佛祖知道是什么意思
//
//              现在,只有佛祖知道

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.VideoView;

/********************************************************
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 ********************************************************
 *       一个疯子
 *       2018/10/23 15:30 
 **/

public class CustomVideoView  extends VideoView {
    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //我们重新计算高度
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
    @Override
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener l) {
        super.setOnPreparedListener(l);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
