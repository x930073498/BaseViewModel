package com.mvvm.x930073498.BaseViewModelLib.core;

import android.support.annotation.LayoutRes;

/**
 * Created by x930073498 on 2017/9/27.
 */

public interface DataBindingLayoutProvider extends BaseProvider{
    @LayoutRes
    int layout();

    int NO_ID = 0;

    int variableId() ;

}
