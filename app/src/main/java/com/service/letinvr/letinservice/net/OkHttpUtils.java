package com.service.letinvr.letinservice.net;


import com.service.letinvr.letinservice.net.callback.LetinCallback;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
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

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient okHttpClient;

    //构造函数私有化
    private OkHttpUtils() {


        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sslContext = null;

        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init((KeyManager[]) null, trustAllCerts, new SecureRandom());
        } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
        } catch (KeyManagementException var5) {
            var5.printStackTrace();
        }

        okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslContext.getSocketFactory())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
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


    @Override
    public void postDate(String url, String jsonDate, String cookie, final int max, final LetinCallback callback) {
        RequestBody body = RequestBody.create(JSON, jsonDate);
        Request request = new Request.Builder()
                .url(url)
                .header("Cookie", cookie)
                .post(body)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                callback.onError(404, e.getMessage(), max);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String json = response.body().string();
                callback.onSuccess(json, max);

            }
        });

    }

    @Override
    public void postEPG(String url, Map<String, String> params, String cookie, final int index, final LetinCallback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString(),index);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                        callback.onSuccess(response.body().string(),index);

            }
        });
    }


}
