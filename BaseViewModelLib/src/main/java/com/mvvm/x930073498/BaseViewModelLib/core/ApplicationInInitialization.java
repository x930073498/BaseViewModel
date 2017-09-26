package com.mvvm.x930073498.BaseViewModelLib.core;

import android.app.Application;

/**
 * Created by x930073498 on 2017/9/27.
 */

public class ApplicationInInitialization {
    public static void attach(Application app) {
        app.registerActivityLifecycleCallbacks(new MyLifeCycleCallback(app));
    }



}
