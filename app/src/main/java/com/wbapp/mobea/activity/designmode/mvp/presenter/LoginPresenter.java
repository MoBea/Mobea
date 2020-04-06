package com.wbapp.mobea.activity.designmode.mvp.presenter;

import com.wbapp.mobea.activity.designmode.mvp.model.Lisentener.LoginLisentener;
import com.wbapp.mobea.activity.designmode.mvp.model.LoginMode;
import com.wbapp.mobea.activity.designmode.mvp.view.ILoginView;
import com.wbapp.mobea.activity.designmode.mvp.view.IView;

import java.lang.ref.WeakReference;

public class LoginPresenter extends PresenterFather {

    public LoginPresenter(ILoginView loginView) {
        this.mIModel = new LoginMode();
        this.mViewReference = new WeakReference<IView>(loginView);
    }

    public void login() {
        if (mIModel != null && mViewReference != null && mViewReference.get() != null) {

            ILoginView loginView = (ILoginView) mViewReference.get();
            String name = loginView.getUserName();
            String passWord = loginView.getPassword();
            loginView = null;
            //此时LoginListener作为匿名内部类是持有外部类的引用的。
            ((LoginMode) mIModel).login(name, passWord, new LoginLisentener() {
                @Override
                public void onSeccess() {
                    if (mViewReference.get() != null) {
                        ((ILoginView) mViewReference.get()).onLoginSeccess();
                    }
                }

                @Override
                public void onFails() {
                    if (mViewReference.get() != null) {
                        if (mViewReference.get() != null) {
                            ((ILoginView) mViewReference.get()).onLoginFails();
                        }
                    }
                }
            });
        }
    }
}
