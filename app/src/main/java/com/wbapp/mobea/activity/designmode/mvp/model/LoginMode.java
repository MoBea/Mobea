package com.wbapp.mobea.activity.designmode.mvp.model;

import com.wbapp.mobea.activity.designmode.mvp.model.Lisentener.LoginLisentener;

public class LoginMode implements IModel {
    private String mUserName = "mobea";
    private String mPassWord = "123456";
    public void login(String mUserName, String mPassWord, LoginLisentener lisentener){
        if(lisentener == null){
            return;
        }
        if(this.mUserName.equals(mUserName) && this.mPassWord.equals(mPassWord)){
            lisentener.onSeccess();
        }else{
            lisentener.onFails();
        }
    }
}
