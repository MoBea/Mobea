package com.wbapp.mobea.activity;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.wbapp.mobea.R;
import com.wbapp.mobea.activity.MainActivity;
import com.wbapp.mobea.activity.designmode.mvc.MVCActivity;
import com.wbapp.mobea.activity.designmode.mvp.activity.MVPActivity;
import com.wbapp.mobea.activity.designmode.mvvm.MVVMActivity;
import com.wbapp.mobea.base.BaseActivity;
import com.wbapp.mobea.utils.Loger;
import com.wbapp.mobea.utils.T;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * @author BaiRuizhi
 * @date 2019/1/3
 * @description eazyPermission 的用例Activity
 */
public class PermissionActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //所要申请的权限
        String[] perms = {
                //模拟器无法获取此权限
               // Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };

        if (EasyPermissions.hasPermissions(this, perms)) {//检查是否获取该权限
            Loger.i("已获取权限");
           // startActivity(new Intent(this, MainActivity.class));
           // startActivity(new Intent(this, MVCActivity.class));
           // startActivity(new Intent(this, MVPActivity.class));
            startActivity(new Intent(this, MVVMActivity.class));
            finish();
        } else {
            //第二个参数是被拒绝后再次申请该权限的解释
            //第三个参数是请求码
            //第四个参数是要申请的权限
            EasyPermissions.requestPermissions(this, "必要的权限", 0, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //把申请权限的回调交由EasyPermissions处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    //下面两个方法是实现EasyPermissions的EasyPermissions.PermissionCallbacks接口
    //分别返回授权成功和失败的权限
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Loger.i("获取成功的权限" + perms.toString());
    }
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Loger.i("获取失败的权限" + perms.toString());
        T.showShort(this,"获取失败的权限" + perms.toString());
    }
}
