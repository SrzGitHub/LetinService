package com.service.letinvr.letinservice.net;


import android.util.Log;

import com.google.gson.Gson;
import com.service.letinvr.letinservice.app.APP;
import com.service.letinvr.letinservice.net.callback.LetinNetWorkCallback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

public class OkHttpUtils implements IHttp {
    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 60;
    public final static int WRITE_TIMEOUT = 60;
    public final static int MAX = 10 * 1024 * 1024;
    private static final String TAG = "OkHttpUtils";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient okHttpClient;

    //构造函数私有化
    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder().
                addNetworkInterceptor(new CacheInterceptor())
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                .build();


    }

    private static OkHttpUtils okHttpUtils;

    //提供一个公共的、静态的、返回值类型是当前本类的对象
    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }

    /**
     * 发送get请求
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param callback 回调
     * @param <T>      请求回来的数据对应的JavaBean
     */
    @Override
    public <T> void get(String url, Map<String, String> params, final LetinNetWorkCallback<T> callback) {

        final StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();


        }

        final Request request = new Request.Builder()
                .url(url).build();


        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
                APP.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程

                        callback.onError(404, e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();

                //执行在子线程中
                APP.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        Log.e(TAG, "onResponse: " + jsonData);
                        callback.onSuccess(getGeneric(jsonData, callback));
                    }
                });

            }
        });

    }

    @Override
    public <T> void post(String url, Map<String, String> params, final LetinNetWorkCallback<T> callback) {

        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key, value);
            }
        }

        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                APP.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404, e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();


                //执行在子线程中
                APP.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData, callback));
                    }
                });

            }
        });
    }


    /**
     * @param url      请求地址
     * @param json     请求数据
     * @param callback 结果回调
     * @param <T>      泛型
     */
    @Override
    public <T> void postJson(String url, String json, final LetinNetWorkCallback<T> callback) {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                APP.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(404, e.getMessage());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json = response.body().string();

                APP.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSucces(json);
                    }
                });

            }
        });


    }

    /**
     * 自动解析json至回调中的JavaBean
     *
     * @param jsonData
     * @param callBack
     * @param <T>
     * @return
     */
    private <T> T getGeneric(String jsonData, LetinNetWorkCallback<T> callBack) {
        Gson gson = new Gson();


        //通过反射获取泛型的实例
        Log.e(TAG, "getGeneric: " + jsonData);
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData, type);
        return t;


    }

    /**
     * 缓存拦截器
     */
    private static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Response response = chain.proceed(request);
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                    .build();
            return response1;
        }
    }

}
