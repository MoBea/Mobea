package com.wbapp.mobea.activity.designmode.mvp.presenter;

import com.wbapp.mobea.activity.designmode.mvp.model.IModel;
import com.wbapp.mobea.activity.designmode.mvp.view.IView;

import java.lang.ref.WeakReference;

/**
 * Presenter 父类
 *
 */
public class PresenterFather {

    protected IModel mIModel;

    protected WeakReference<IView> mViewReference;

}
