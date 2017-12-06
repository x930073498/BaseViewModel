package com.x930073498.baseviewmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mvvm.x930073498.BaseViewModelLib.core.ActivityDataBindingProvider;
import com.mvvm.x930073498.BaseViewModelLib.core.ContextToastProvider;
import com.mvvm.x930073498.BaseViewModelLib.core.annotation.InjectMethod;
import com.x930073498.baseviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ActivityDataBindingProvider<ActivityMainBinding> {
    ActivityMainBinding binding;
    ContextToastProvider provider;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toast("test", Toast.LENGTH_SHORT);

    }


    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public int variableId() {
        return BR.activity;
    }

    @Override
    public void provideViewDataBinding(ActivityMainBinding dataBinding) {
        binding = dataBinding;
    }


    public void onClick(View view) {
        provider.showToast("测试");
    }

    @InjectMethod(value = ToastProvider.class,methodName = "showToast")
    public void toast(CharSequence msg, int duration) {

    }

    @InjectMethod(value = ToastProvider.class,methodName = "showToast")
    public void toast(CharSequence msg) {

    }
}
