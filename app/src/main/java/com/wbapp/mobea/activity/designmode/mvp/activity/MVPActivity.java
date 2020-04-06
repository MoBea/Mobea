package com.wbapp.mobea.activity.designmode.mvp.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.wbapp.mobea.R;
import com.wbapp.mobea.activity.designmode.mvp.presenter.LoginPresenter;
import com.wbapp.mobea.activity.designmode.mvp.view.ILoginView;
import com.wbapp.mobea.base.BaseActivity;
import com.wbapp.mobea.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVP的优缺点
 * 优点： 单一职责， Model， View， Presenter只处理单一逻辑
 * 解耦：Model层的修改和View层的修改互不影响
 * 面向接口编程，依赖抽象：Presenter和View互相持有抽象引用，对外隐藏内部实现细节。
 * 可能存在的问题：
 * Model进行一步操作的时候，获取结果通过Presenter会传到View的时候，出现View引用的空指针异常。
 * Presenter和View相互持有引用，解除不及时的话容易出现内存泄漏。
 * ==========================================================
 * MVPActivity  = View
 * Model = Controller & Model
 * Presenter = Controller
 */
public class MVPActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.mvp_login)
    Button mvpLogin;
    @BindView(R.id.mvp_user)
    EditText mvpUser;
    @BindView(R.id.mvp_password)
    EditText mvpPassword;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        ButterKnife.bind(this);
        setData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mPresenter = null;
    }

    private void setData() {
        this.mPresenter = new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return mvpUser.getText().toString();
    }

    @Override
    public String getPassword() {
        return mvpPassword.getText().toString();
    }

    @Override
    public void onLoginSeccess() {
        T.showShort(MVPActivity.this, "登录成功");
    }

    @Override
    public void onLoginFails() {
        T.showShort(MVPActivity.this, "登录失败");
    }

    @OnClick(R.id.mvp_login)
    public void onViewClicked() {
        //隐藏软键盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        mPresenter.login();
    }

}
