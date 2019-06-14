package com.letinvr.fjcmcclibrary;


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

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 * <p>
 * 2018/11/30 13:57
 **/

public class LogToFile {


    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);//日期格式;

    static String className;//类名
    static String methodName;//方法名
    static int lineNumber;//行数
    public static String logPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Logs";
    private static final String TAG = "LogToFile";


    /**
     * 判断是否可以调试
     * @return
     */
    public static boolean isDebuggable() {
        return true;
    }

    private static String createLog(String log ) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Methods：");
        buffer.append(methodName);
        buffer.append(" (").append(className).append(":").append(lineNumber).append(") Msg: ");
        buffer.append(log);
        return buffer.toString();
    }

    /**
     * 获取文件名、方法名、所在行数
     * @param sElements
     */
    private static void getMethodNames(StackTraceElement[] sElements){
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message){
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.e("||", createLog(message));
//        writeToFile("E",className,createLog(message));
    }

    public static void i(String message){
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.i("||", createLog(message));
//        writeToFile("I",className,createLog(message));
    }

    public static void d(String message){
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.d("||", createLog(message));
    }

    public static void v(String message){
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.v("||", createLog(message));
//        writeToFile("V",className,createLog(message));
    }

    public static void w(String message){
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.w("||", createLog(message));
//        writeToFile("W",className,createLog(message));
    }

    /**
     * 将log信息写入文件中
     *
     * @param type
     * @param tag
     * @param msg
     */
    private static void writeToFile(String type, String tag, String msg) {


        String fileName = logPath + "/App"+"Maket.log" ;//log日志名，使用时间命名，保证不重复
        String log = dateFormat.format(new Date()) + " " + type + " " + tag + " " + msg + "\n";//log日志内容，可以自行定制
        //如果父路径不存在
        File file = new File(logPath);
        if (!file.exists()) {
            file.mkdirs();//创建父路径
        }

        FileOutputStream fos = null;//FileOutputStream会自动调用底层的close()方法，不用关闭
        BufferedWriter bw = null;
        try {

            fos = new FileOutputStream(fileName, true);//这里的第二个参数代表追加还是覆盖，true为追加，flase为覆盖
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(log);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();//关闭缓冲流
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
