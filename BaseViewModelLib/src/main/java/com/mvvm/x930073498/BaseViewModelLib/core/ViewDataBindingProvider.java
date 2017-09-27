package com.mvvm.x930073498.BaseViewModelLib.core;

import android.databinding.ViewDataBinding;

/**
 * Created by x930073498 on 2017/9/27.
 */

public interface ViewDataBindingProvider<T extends ViewDataBinding> extends BaseProvider {
    void provideViewDataBinding(T dataBinding);
}
