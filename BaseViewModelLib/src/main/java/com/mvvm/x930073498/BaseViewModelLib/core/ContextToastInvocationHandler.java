package com.mvvm.x930073498.BaseViewModelLib.core;

import android.content.Context;
import android.widget.Toast;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by x930073498 on 2017/9/27.
 */

public class ContextToastInvocationHandler implements InvocationHandler, ContextToastProvider {
    Context context;

    protected ContextToastInvocationHandler(Context context) {
        this.context = context;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (objects != null) {
            if (objects.length == 1) {
                showToast(objects[0].toString());
                return method.invoke(o, objects);
            } else {
                showToast((CharSequence) objects[0], (int) objects[1]);
                return method.invoke(o, objects);
            }
        } else return method.invoke(o, objects);
    }

    @Override
    public void showToast(CharSequence msg, @ToastDuration int duration) {
        Toast.makeText(context, msg, duration).show();
    }

    @Override
    public void showToast(CharSequence msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }
}
