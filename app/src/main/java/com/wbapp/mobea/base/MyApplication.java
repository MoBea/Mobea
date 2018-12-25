package com.wbapp.mobea.base;
import android.app.Application;
import com.wbapp.mobea.utils.MyCrashHandler;
/**
 * @author BaiRuizhi
 * @date 2018/8/6
 * @body
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //打开错误日志,保存到SDCard
        MyCrashHandler myCrashHandler = MyCrashHandler.getInstance();
        myCrashHandler.init(getApplicationContext());
    }
}
