package com.x930073498.baseviewmodel;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectTest {

    private static final String TAG = "xuyisheng";

    @After("execution(* com.mvvm.x930073498.BaseViewModelLib.core.ContextToastProvider.**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {

        Log.d(TAG, "onActivityMethodBefore:getKind= "+joinPoint.getKind());
        Log.d(TAG, "onActivityMethodBefore: getArgs="+joinPoint.getArgs());
        Log.d(TAG, "onActivityMethodBefore: getSignature="+joinPoint.getSignature().getName());
        Log.d(TAG, "onActivityMethodBefore: getSourceLocation="+joinPoint.getSourceLocation());
        Log.d(TAG, "onActivityMethodBefore: getStaticPart="+joinPoint.getStaticPart());
        Log.d(TAG, "onActivityMethodBefore:getTarget="+joinPoint.getTarget());
        Log.d(TAG, "onActivityMethodBefore: getThis="+joinPoint.getThis());
    }
}