package com.wbapp.mobea.utils.adaptation;


import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * @author BaiRuizhi
 * @date 2019/1/3
 * @description 屏幕适配工具类
 */
public class LeadAdaptation {

    // 系统的Density
    private static float sNoncompatDensity;
    // 系统的ScaledDensity
    private static float sNoncompatScaledDensity;

    /**
     * 今日头条适配方法
     * 缺点:
     *   只能适配宽度或者高度其一
     * 使用方法:
     *   只需要在Activity中调用就行了，必须在setContentView()之前.
     * **********************
     * @param activity
     * @param application
     */
    public static void setCustomDensity(Activity activity, final Application application) {
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (sNoncompatDensity == 0) {
            sNoncompatDensity = displayMetrics.density;
            sNoncompatScaledDensity = displayMetrics.scaledDensity;
            // 监听在系统设置中切换字体(不添加监听,则字体不会跟随系统设置改变而改变)
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNoncompatScaledDensity=application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }
                @Override
                public void onLowMemory() {

                }
            });
        }
        // 此处以360dp的设计图作为例子
        float targetDensity=displayMetrics.widthPixels/360;
        float targetScaledDensity=targetDensity*(sNoncompatScaledDensity/sNoncompatDensity);
        int targetDensityDpi= (int) (160 * targetDensity);
        displayMetrics.density = targetDensity;
        displayMetrics.scaledDensity = targetScaledDensity;
        displayMetrics.densityDpi = targetDensityDpi;

        DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }

}
