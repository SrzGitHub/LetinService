package com.service.letinvr.letinservice.api;

import android.content.Context;

import com.service.letinvr.letinservice.moudle.bean.authorization.QueryAuthorizationRel;
import com.service.letinvr.letinservice.moudle.bean.authorization.QueryAuthorizationReturn;
import com.service.letinvr.letinservice.moudle.bean.authorization.QueryAuthorizationReturnRoot;
import com.service.letinvr.letinservice.moudle.bean.bindauthorization.UnBindAuthorizationRel;
import com.service.letinvr.letinservice.moudle.bean.bindauthorization.UnBindReturn;
import com.service.letinvr.letinservice.moudle.bean.bindtv.QueryBindTVList;
import com.service.letinvr.letinservice.moudle.bean.bindtv.QueryBindTVListReturn;
import com.service.letinvr.letinservice.moudle.bean.getverifycode.GetVerifyCode;
import com.service.letinvr.letinservice.moudle.bean.getverifycode.GetVerifyCodeReturn;
import com.service.letinvr.letinservice.moudle.bean.verifycode.QueryVerifyCode;
import com.service.letinvr.letinservice.moudle.bean.verifycode.QueryVerifyCodeReturn;
import com.service.letinvr.letinservice.moudle.bean.verifycode.QueryVerifyCodeRoot;
import com.service.letinvr.letinservice.moudle.hvsdate.HVSAuthentivate;


import java.util.ArrayList;
import java.util.List;

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
 * 2019/05/11 15:11 星期六
 **/
public class TranformJson {
    public static QueryAuthorizationRel rel;
    public static QueryVerifyCode verifyCode;
    public static QueryBindTVList bindTVList;
    public static UnBindAuthorizationRel unBindAuthorizationRel;
    public static HVSAuthentivate hvsAuthentivate;
    public static HVSAuthentivate.AuthenticateBasicBean authenticateBasicBran;
    public static HVSAuthentivate.AuthenticateDeviceBean authenticateDeviceBean;

    public static QueryVerifyCodeReturn queryVerifyCodeReturn;
    public static QueryVerifyCodeRoot verifyCodeRoot;
    public static QueryAuthorizationReturn authorization;
    public static QueryAuthorizationReturnRoot returnRoots;
    public static QueryBindTVListReturn bindTVListReturn;
    public static GetVerifyCodeReturn codeReturn;
    public static UnBindReturn unBindReturn;
    public static List<QueryBindTVListReturn.DataBean> data;
    public static List<String> mList =new ArrayList<>();
    private static HVSAuthentivate.AuthenticateBasicBean.ExtensionFieldsBean extensionFieldsBean;

    public static String getVrRootResult() {
        //获取手机与一体机授权关系
        rel = new QueryAuthorizationRel();
        rel.setAppId(PresenterConstant.APP_ID);
        rel.setReqType("2");
        rel.setTimestamp(PresenterConstant.stampToDate());
        rel.setVRId(Constant.getMAC());
        rel.setToken(PresenterConstant.getToken(PresenterConstant.stampToDate()));
        return  PresenterConstant.getJson(rel);
    }


    public static String obtainAuthorizationVerificationCode() {
        //获取授权验证码

        GetVerifyCode code = new GetVerifyCode();
        code.setAppId(PresenterConstant.APP_ID);
        code.setTimestamp(PresenterConstant.stampToDate());
        code.setToken(PresenterConstant.getToken(PresenterConstant.stampToDate()));
        code.setVRId(Constant.getMAC());
        code.setName(PresenterConstant.getDeviceModel());
        return PresenterConstant.getJson(code);

    }

    public static String pollingVerificationCode() {
        //轮训验证码状态
        verifyCode = new QueryVerifyCode();
        verifyCode.setAppId(PresenterConstant.APP_ID);
        verifyCode.setTimestamp(PresenterConstant.stampToDate());
        verifyCode.setSign(PresenterConstant.getSign(codeReturn.getVerifyCode()));
        verifyCode.setToken(PresenterConstant.getToken(PresenterConstant.stampToDate()));
        verifyCode.setVRId(Constant.getMAC());
        verifyCode.setVerifyCode(codeReturn.getVerifyCode());
        return PresenterConstant.getJson(verifyCode);

    }

    public static String queryBindTVList() {
        //查询绑定机顶盒信息
        bindTVList = new QueryBindTVList();
        bindTVList.setTimestamp(PresenterConstant.stampToDate());
        bindTVList.setToken(PresenterConstant.getToken(PresenterConstant.stampToDate()));
        bindTVList.setXmppAccount(PresenterConstant.getKey(Constant.MTV_ACCOUNT));
        bindTVList.setAppId(PresenterConstant.APP_ID);
        bindTVList.setMtvAccount(PresenterConstant.getKey(Constant.MTV_ACCOUNT));
        return PresenterConstant.getJson(bindTVList);
    }

    public static String unbind() {
        //解除绑定

        unBindAuthorizationRel = new UnBindAuthorizationRel();
        unBindAuthorizationRel.setAppId(PresenterConstant.APP_ID);
        unBindAuthorizationRel.setMtvAccount(PresenterConstant.getKey(Constant.MTV_ACCOUNT));
        unBindAuthorizationRel.setTimestamp(PresenterConstant.stampToDate());
        unBindAuthorizationRel.setToken(PresenterConstant.getToken(PresenterConstant.stampToDate()));
        unBindAuthorizationRel.setVRId(Constant.getMAC());
        return PresenterConstant.getJson(unBindAuthorizationRel);


    }


}
