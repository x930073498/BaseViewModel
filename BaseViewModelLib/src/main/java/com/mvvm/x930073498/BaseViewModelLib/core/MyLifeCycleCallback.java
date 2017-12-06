package com.mvvm.x930073498.BaseViewModelLib.core;

import android.app.Activity;
import android.app.Application;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Proxy;

public class MyLifeCycleCallback implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "MyLifeCycleCallback";
    private Application application;
    private MapProvider provider;

    //利用动态代理去实现put get方法
    protected MyLifeCycleCallback(Application application) {
        this.application = application;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.d(TAG, "onActivityCreated: ");
        registerContextToastProvider(activity);
        provider = registerMapProvider(activity);
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
    }

    private MapProvider registerMapProvider(Activity activity) {
        if (activity instanceof MapProvider) {
            MapProvider provider = (MapProvider) Proxy.newProxyInstance(activity.getClassLoader(), new Class[]{MapProvider.class}, MapProviderInvocationHandler.create(application, (MapProvider) activity));
            provider.put(MapProvider.class, provider);
            return provider;
        }
        return null;
    }
}