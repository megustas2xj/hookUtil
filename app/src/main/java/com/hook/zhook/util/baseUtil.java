package com.hook.zhook.util;

import java.lang.reflect.Method;

public class baseUtil {


    /**
     * hex转byte数组
     * @param hex
     * @return
     */
    public static byte[] hexToByte(String hex){
        int m = 0, n = 0;
        int byteLen = hex.length() / 2; // 每两个字符描述一个字节
        byte[] ret = new byte[byteLen];
        for (int i = 0; i < byteLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));
            ret[i] = Byte.valueOf((byte)intVal);
        }
        return ret;
    }

    /**
     * byte数组转hex
     * @param bytes
     * @return
     */
    public static String byteToHex(byte[] bytes){
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
        }
        return sb.toString().trim();
    }

    /**
     * 打印堆栈信息
     * @param
     * @return
     */
    public static void  showStack(){

        LogUtil.LogUtil(2,"Dump Stack","---------------start----------------");
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                LogUtil.LogUtil(3,"Dump Stack", "["+i+"]"+":"
                        + stackElements[i].getClassName()
                        +"----"+stackElements[i].getFileName()
                        +"----" + stackElements[i].getLineNumber()
                        +"----" +stackElements[i].getMethodName());
            }
        }
        LogUtil.LogUtil(2,"Dump Stack","---------------over----------------");
    }

    /**
     * 打印类的方法
     * @param
     * @return
     */

    public static void getMethodName(String ClassName) throws ClassNotFoundException{

        Class<?> classType=Class.forName(ClassName);
        Method[] methods=classType.getDeclaredMethods();
        for (int i=0;i<methods.length;i++){
            LogUtil.LogUtil(5,"MethodName","["+i+"]"+methods[i].toString());
        }

    }

}
