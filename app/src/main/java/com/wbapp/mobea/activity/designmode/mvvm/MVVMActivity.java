package com.wbapp.mobea.activity.designmode.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.wbapp.mobea.R;
import com.wbapp.mobea.base.BaseActivity;
import com.wbapp.mobea.databinding.MVVM;

/**
 * https://www.jianshu.com/p/545af5bbb93f 参考文档
 *
 * MVVM 模式
 * MVVM设计模式的优点
 * 1.双向绑定技术，当Model变化时，View-Model会自动更新，View也会自动变化。很好做到数据的一致性，
 * 所以 MVVM模式有些时候又被称作：model-view-binder模式。
 * 2.View的功能进一步的强化，具有控制的部分功能，若想无限增强它的功能，
 * 甚至控制器的全部功几乎都可以迁移到各个View上（不过这样不可取，那样View干了不属于它职责范围的事情）。
 * View可以像控制器一样具有自己的View-Model.
 * 3.由于控制器的功能大都移动到View上处理，大大的对控制器进行了瘦身。不用再为看到庞大的控制器逻辑而发愁了。
 * 4.可以对View或ViewController的数据处理部分抽象出来一个函数处理model。
 * 这样它们专职页面布局和页面跳转，它们必然更一步的简化。
 * =====================================================================================
 * MVVM设计模式的缺点
 * 1：数据绑定使得 Bug 很难被调试。你看到界面异常了，有可能是你 View 的代码有 Bug，也可能是 Model 的代码有问题。
 * 数据绑定使得一个位置的 Bug 被快速传递到别的位置，要定位原始出问题的地方就变得不那么容易了。
 * 2：一个大的模块中，model也会很大，虽然使用方便了也很容易保证了数据的一致性，当时长期持有，不释放内存，就造成了花费更多的内存。
 * 3：数据双向绑定不利于代码重用。客户端开发最常用的重用是View，但是数据双向绑定技术，让你在一个View都绑定了一个model，不同模块的model都不同。那就不能简单重用View了。
 */
public class MVVMActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MVVM mvvm = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        User user = new User("盖伦", "13834262360");
        mvvm.setUser(user);
    }
}
