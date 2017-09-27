package com.x930073498.baseviewmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mvvm.x930073498.BaseViewModelLib.core.ActivityDataBindingProvider;
import com.mvvm.x930073498.BaseViewModelLib.core.ContextToastInvocationHandler;
import com.mvvm.x930073498.BaseViewModelLib.core.ContextToastProvider;
import com.mvvm.x930073498.BaseViewModelLib.core.ToastDuration;
import com.x930073498.baseviewmodel.databinding.ActivityMainBinding;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity implements ActivityDataBindingProvider<ActivityMainBinding>, ContextToastProvider {
    ActivityMainBinding binding;
    ContextToastProvider provider;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provider = (ContextToastProvider) Proxy.newProxyInstance(getClassLoader(), new Class[]{ContextToastProvider.class}, new ContextToastInvocationHandler(this, this));
        binding.setActivity(this);

    }


    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void provideViewDataBinding(ActivityMainBinding dataBinding) {
        binding = dataBinding;
    }

    @Override
    public void showToast(CharSequence msg, @ToastDuration int duration) {
        Log.d(TAG, "showToast: enter this line1");
    }

    @Override
    public void showToast(CharSequence msg) {
        Log.d(TAG, "showToast: enter this line2");

    }

    public void onClick(View view) {
        provider.showToast("测试");
    }
}
