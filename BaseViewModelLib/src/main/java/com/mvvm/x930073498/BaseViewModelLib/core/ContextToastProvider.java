package com.mvvm.x930073498.BaseViewModelLib.core;

import android.content.Context;
import android.support.annotation.IntDef;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by x930073498 on 2017/9/27.
 */

public interface ContextToastProvider {

    void showToast(CharSequence msg, @ToastDuration int duration);

    void showToast(CharSequence msg);
}
