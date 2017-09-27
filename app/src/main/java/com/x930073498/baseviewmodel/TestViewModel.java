package com.x930073498.baseviewmodel;

import com.mvvm.x930073498.BaseViewModelLib.core.BaseViewModel;

/**
 * Created by x930073498 on 2017/9/27.
 */

public class TestViewModel implements BaseViewModel {
    @Override
    public Object parent() {
        return null;
    }

    @Override
    public int layout() {
        return 0;
    }

    @Override
    public int variableId() {
        return 0;
    }
}
