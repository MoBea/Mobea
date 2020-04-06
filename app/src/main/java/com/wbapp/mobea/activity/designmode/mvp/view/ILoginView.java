package com.wbapp.mobea.activity.designmode.mvp.view;

public interface ILoginView extends IView {
    String getUserName();

    String getPassword();

    void onLoginSeccess();

    void onLoginFails();
}
