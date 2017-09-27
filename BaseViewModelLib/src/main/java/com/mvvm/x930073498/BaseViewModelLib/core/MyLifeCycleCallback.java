package com.mvvm.x930073498.BaseViewModelLib.core;

import android.app.Activity;
import android.app.Application;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import java.lang.reflect.Proxy;

public class MyLifeCycleCallback implements Application.ActivityLifecycleCallbacks {
    private Application application;

    protected MyLifeCycleCallback(Application application) {
        this.application = application;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        registerContextToastProvider(activity);
        if (activity instanceof DataBindingLayoutProvider) {
            ViewDataBinding binding;
            if (activity instanceof ViewDataBindingProvider) {
                ((ViewDataBindingProvider<ViewDataBinding>) activity).provideViewDataBinding((binding = DataBindingUtil.setContentView(activity, ((DataBindingLayoutProvider) activity).layout())));
            } else {
                binding = DataBindingUtil.setContentView(activity, ((DataBindingLayoutProvider) activity).layout());
            }
            if (((DataBindingLayoutProvider) activity).variableId() != DataBindingLayoutProvider.NO_ID)
                binding.setVariable(((DataBindingLayoutProvider) activity).variableId(), activity);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    private void registerContextToastProvider(Activity activity) {
        if (activity instanceof ContextToastProvider) {
            Proxy.newProxyInstance(activity.getClassLoader(), new Class[]{ContextToastProvider.class}, ContextToastInvocationHandler.create(application, (ContextToastProvider) activity));
        }
    }
}