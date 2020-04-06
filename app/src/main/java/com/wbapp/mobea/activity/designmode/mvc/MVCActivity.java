package com.wbapp.mobea.activity.designmode.mvc;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.wbapp.mobea.R;
import com.wbapp.mobea.base.BaseActivity;

/**
 * View-Controller-Model
 * View接收到用户的操作
 * View将用户的操作，交给Controller
 * Controller完成具体的业务逻辑
 * 得到结果封装成Model，再进行View的更新
 * ====================================
 * Controller：Activity和Fragment（ImageDewnLoad和Callback只是为了我们解耦Activity中的代码，
 *    你也可以把它全写在Activity中，但是后期维护会比较困难）
 * Model：实体类作为Model层，一般我们会在项目中创建一个bean包放置各种ModelBean，
 *    比如网络请求返回的UserBean和本案例中的ImageBean
 * View：MXL和自定义View等
 *====================================
 * xml = View
 * MVCActivity : 在View 和 Conroller 中间件
 * CallBack,ImageDownloader = Controller
 * ImageBean = Model
 * ===================================
 *
 */
public class MVCActivity extends BaseActivity implements CallBack{
    private ImageView imageView;
    private static final String path = "http://photocdn.sohu.com/20130416/Img372885486.jpg";
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case ImageDownloader.SUCCESS://请求成功
                    imageView.setImageBitmap((Bitmap) msg.obj);
                    break;
                case ImageDownloader.ERROR://请求失败
                    Toast.makeText(MVCActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }

    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        imageView = findViewById(R.id.mvc_image);
    }


    public void getImage(View view){
        ImageBean imageBean=new ImageBean();
        imageBean.setRequestPath(path);
        ImageDownloader.down(this,imageBean);
    }
    @Override
    public void callback(int resultCode, ImageBean bitmap) {
        Message message = handler.obtainMessage(resultCode);
        message.obj = bitmap.getBitmap();
        handler.sendMessageDelayed(message, 500);
    }
}
