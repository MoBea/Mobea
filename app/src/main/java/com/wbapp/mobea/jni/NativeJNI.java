package com.wbapp.mobea.jni;

/**
 * @author BaiRuizhi
 * @date 2018/12/25
 * @description
 */
public class NativeJNI {
    static {
        System.loadLibrary("native-lib");
    }

    private static volatile NativeJNI instance;
    private NativeJNI() {}
    public static NativeJNI getInstance() {
        if (instance == null) {
            synchronized (NativeJNI.class) {
                if (instance == null) {
                    instance = new NativeJNI();
                }
            }
        }
        return instance;
    }

    public native String stringFromJNI();

    public native String stringFromNameJNI(String name);
}
