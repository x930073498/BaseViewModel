package com.mvvm.x930073498.BaseViewModelLib.core;

import android.support.annotation.IntDef;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({Toast.LENGTH_SHORT, Toast.LENGTH_LONG})
public @interface ToastDuration {
}