package com.service.letinvr.letinservice.presenter;


import com.service.letinvr.letinservice.contract.LetinContract;
import com.service.letinvr.letinservice.moudle.LetinModel;
import com.service.letinvr.letinservice.moudle.LetinModelImpl;
import com.service.letinvr.letinservice.net.callback.LetinCallback;

import java.util.Map;


public class LetinPresenter implements LetinContract.Presenter {

    private LetinModel pandaLiveModel;
    private LetinContract.View letinView;
    public LetinPresenter(LetinContract.View letinView){
        this.letinView = letinView;
        this.letinView.setPresenter(this);
        pandaLiveModel = new LetinModelImpl();
    }



    @Override
    public void start(String url, String strJson, String strHand, int index) {
        pandaLiveModel.postDate(url, strJson, strHand, index, new LetinCallback() {
            @Override
            public void onSuccess(String josn, int max) {
                letinView.setResult(josn,max);
            }

            @Override
            public void onError(int errorCode, String errorMsg, int max) {
                letinView.showMessage(errorMsg,max);
            }
        });
    }

    @Override
    public void start(String url, Map<String, String> mMap, String cookie, int index) {
        pandaLiveModel.postEPG(url, mMap, cookie, index, new LetinCallback() {
            @Override
            public void onSuccess(String josn, int max) {
                letinView.setResult(josn,max);
            }

            @Override
            public void onError(int errorCode, String errorMsg, int max) {
                letinView.showMessage(errorMsg,max);
            }
        });
    }
}
