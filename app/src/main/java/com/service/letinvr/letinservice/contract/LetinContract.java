package com.service.letinvr.letinservice.contract;


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

import com.service.letinvr.letinservice.base.BasePresenter;
import com.service.letinvr.letinservice.base.BaseView;

/***********************************************************
 *                                                         *
 * You may think you know what the following code does.    *
 * But you dont. Trust me.                                 *
 * Fiddle with it, and youll spend many a sleepless        *
 * night cursing the moment you thought youd be clever     *
 * enough to "optimize" the code below.                    *
 * Now close this file and go play with something else.    *
 *                                                         *
 *              2018/11/22 15:52                           *
 ***********************************************************/

public interface LetinContract {
    interface View extends BaseView<LetinContract.Presenter> {
        void setResult(String result,int index);
        void showMessage(String error,int index);
    }

    interface Presenter extends BasePresenter {

    }
}
