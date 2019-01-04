package com.wbapp.mobea.base;
import android.app.Application;
import com.wbapp.mobea.utils.MyCrashHandler;
import com.wbapp.mobea.utils.adaptation.ScreenAdapter;

/**
 * @author BaiRuizhi
 * @date 2018/8/6
 * @body
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        // 程序创建的时候执行
        super.onCreate();
        //打开错误日志,保存到SDCard
        MyCrashHandler myCrashHandler = MyCrashHandler.getInstance();
        myCrashHandler.init(getApplicationContext());
        //屏幕适配
        ScreenAdapter.setup(this);
        ScreenAdapter.register(this,360,0,0);
    }

    @Override
    public void onTerminate() {
        //程序终止时执行
        super.onTerminate();
        ScreenAdapter.unregister(this,0);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //低内存时执行
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        //程序清理内存执行
    }
}
