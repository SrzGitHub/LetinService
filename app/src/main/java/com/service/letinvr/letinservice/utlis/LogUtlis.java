package com.service.letinvr.letinservice.utlis;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class LogUtlis {

    /**
     * 我是不会写说明的  死了这条心吧
     */
    public static final boolean  DEBUG =true;


    public static void showToast(Context context,String msg){

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    
    public static void E(String tag,String msg){
       if (DEBUG){
           Log.e(tag, msg);
       }
    }

    public static void V(String tag,String msg){
        if (DEBUG){
            Log.v(tag,msg);
        }
    }
    public static void I(String tag,String msg){
        if (DEBUG){
            Log.i(tag,msg);
        }
    }
    public static void W(String tag,String msg){
        if (DEBUG){
            Log.w(tag,msg);
        }
    }
    



}
