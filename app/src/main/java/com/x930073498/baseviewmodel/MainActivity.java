package com.x930073498.baseviewmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mvvm.x930073498.BaseViewModelLib.core.ActivityDataBindingProvider;
import com.mvvm.x930073498.BaseViewModelLib.core.ContextToastProvider;
import com.mvvm.x930073498.BaseViewModelLib.core.ToastDuration;
import com.x930073498.baseviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ActivityDataBindingProvider<ActivityMainBinding>, ContextToastProvider {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToast("",Toast.LENGTH_SHORT);
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
    public void showToast(CharSequence msg,@ToastDuration int duration) {

    }

    @Override
    public void showToast(CharSequence msg) {

    }
}
