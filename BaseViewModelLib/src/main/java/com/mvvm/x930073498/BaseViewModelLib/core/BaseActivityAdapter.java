package com.mvvm.x930073498.BaseViewModelLib.core;

import android.databinding.ViewDataBinding;

/**
 * Created by x930073498 on 2017/9/27.
 */

public interface BaseActivityAdapter<T,V extends ViewDataBinding> extends BaseProvider {
    V bind(BaseViewModel<T> viewModel);

}
