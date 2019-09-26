package com.wbapp.mobea.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;

import com.wbapp.mobea.R;
import com.wbapp.mobea.base.BaseActivity;
import com.wbapp.mobea.jni.NativeJNI;
import com.wbapp.mobea.utils.Loger;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(NativeJNI.getInstance().stringFromJNI());
        tv.setText(NativeJNI.getInstance().stringFromNameJNI("MoBea"));
        Loger.i("=====MainActiviry onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Loger.i("=====MainActiviry onStart");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Loger.i("Down keyCode = "+keyCode+" count = "+event.getRepeatCount());
        return super.onKeyDown(keyCode, event);
        //return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Loger.i("Up keyCode = "+keyCode+" count = "+event.getRepeatCount());
        event.startTracking();
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Loger.i("onKeyLongPress keyCode = "+keyCode);
        return super.onKeyLongPress(keyCode, event);
    }
}
