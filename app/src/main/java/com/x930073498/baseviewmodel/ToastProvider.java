package com.x930073498.baseviewmodel;

import android.content.Context;
import android.widget.Toast;

import com.mvvm.x930073498.BaseViewModelLib.core.ContextToastProvider;

/**
 * Created by x930073498 on 2017/12/6.
 */

public class ToastProvider implements ContextToastProvider {

    private Context context;

    public ToastProvider(Context context) {
        this.context = context;
    }

    @Override
    public void showToast(CharSequence msg, int duration) {
        Toast.makeText(context, msg, duration).show();
    }

    @Override
    public void showToast(CharSequence msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }
}
