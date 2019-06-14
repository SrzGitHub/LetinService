package com.service.letinvr.letinservice.moudle;

import com.service.letinvr.letinservice.net.callback.LetinCallback;

import java.util.Map;

/**
 * Created by xingge on 2017/7/11.
 */

public class LetinModelImpl implements LetinModel {




    @Override
    public void postDate(String url, String json, String strHand, int index, LetinCallback callback) {
        iHttp.postDate(url,json,strHand,index,callback);
    }

    @Override
    public void postEPG(String url, Map<String, String> map, String cookie, int index, LetinCallback callback) {
        iHttp.postEPG(url,map,cookie,index,callback);
    }
}
