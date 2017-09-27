package com.mvvm.x930073498.BaseViewModelLib.core;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by x930073498 on 2017/9/27.
 */

public class ContextToastInvocationHandler implements InvocationHandler, ContextToastProvider {
    private static final String TAG = "ContextToast";
    private ContextToastProvider provider;
    private static Toast toast;

    private ContextToastInvocationHandler(Context context, ContextToastProvider provider) {
        this.provider = provider;
        if (toast == null)
            toast = Toast.makeText(context.getApplicationContext(), "init", Toast.LENGTH_SHORT);
    }
    public static ContextToastInvocationHandler create(Context context,ContextToastProvider provider){
        return new ContextToastInvocationHandler(context, provider);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (objects != null) {
            if (objects.length == 1) {
                showToast(objects[0].toString());
                provider.showToast(objects[0].toString());
                return null;
            } else {
                showToast((CharSequence) objects[0], (int) objects[1]);
                provider.showToast((CharSequence) objects[0], (int) objects[1]);
                return null;
            }
        } else return method.invoke(o, (Object[]) null);
    }

    @Override
    public void showToast(CharSequence msg, @ToastDuration int duration) {
        toast.setDuration(duration);
        toast.setText(msg);
        toast.show();
    }

    @Override
    public void showToast(CharSequence msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }
}
