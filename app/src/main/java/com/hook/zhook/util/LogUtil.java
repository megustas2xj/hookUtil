package com.hook.zhook.util;

import android.util.Log;

public class LogUtil {


    private static final String Tag="zzw-hook";

    public static void LogUtil(int level,String args0,String args1){

        String msg=args0+":"+args1;

        switch (level){
            case 1:
                Log.v(Tag,msg);
                break;
            case 2:
                Log.d(Tag,msg);
                break;
            case 3:
                Log.i(Tag,msg);
                break;
            case 4:
                Log.w(Tag,msg);
                break;
            case 5:
                Log.e(Tag,msg);
                break;
        }
    }
}
