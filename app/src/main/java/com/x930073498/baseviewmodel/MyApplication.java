package com.x930073498.baseviewmodel;

import android.app.Application;

import com.mvvm.x930073498.BaseViewModelLib.core.ApplicationInInitialization;

/**
 * Created by x930073498 on 2017/9/27.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationInInitialization.attach(this);
    }
}
