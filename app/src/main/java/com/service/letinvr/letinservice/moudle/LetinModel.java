package com.service.letinvr.letinservice.moudle;

import com.service.letinvr.letinservice.base.BaseModel;
import com.service.letinvr.letinservice.net.callback.LetinCallback;

import java.util.Map;

/**
 * Created by xingge on 2017/7/11.
 */

public interface LetinModel extends BaseModel {

    void postDate( String url, String json, String strHand,int index,LetinCallback callback);
    void postEPG(String url, Map<String,String> map,  String cookie,int index, LetinCallback callback);
}
