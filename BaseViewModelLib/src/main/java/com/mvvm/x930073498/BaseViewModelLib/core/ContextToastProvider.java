package com.mvvm.x930073498.BaseViewModelLib.core;

/**
 * Created by x930073498 on 2017/9/27.
 */
public interface ContextToastProvider extends BaseProvider{

    void showToast(CharSequence msg, @ToastDuration int duration);

    void showToast(CharSequence msg);

}
