package com.hook.zhook;

import com.hook.zhook.util.LogUtil;
import com.hook.zhook.util.baseUtil;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Hook implements IXposedHookLoadPackage {


    private static final String packageName="";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        LogUtil.LogUtil(2,"start","开始hook");

        if (!lpparam.packageName.equals(packageName)){
            return;
        }
    }
}
