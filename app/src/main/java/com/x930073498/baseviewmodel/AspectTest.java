package com.x930073498.baseviewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.mvvm.x930073498.BaseViewModelLib.core.annotation.InjectMethod;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

@Aspect
public class AspectTest {

    private static final String TAG = "xuyisheng";

    @Around("execution(* *.*(..)) && @annotation(injectMethod)")

    public Object beforeInterfaceInvoke(ProceedingJoinPoint joinPoint, InjectMethod injectMethod) throws Throwable {
        Class targetClass = injectMethod.value();
        Constructor<?>[] constructors = injectMethod.value().getConstructors();
        Object target = getTarget(joinPoint, constructors);
        invokeMethod(joinPoint, injectMethod, targetClass, target);
        return joinPoint.proceed();
    }

    private void invokeMethod(ProceedingJoinPoint joinPoint, InjectMethod injectMethod, Class targetClass, Object target) throws IllegalAccessException, InvocationTargetException {
        if (target != null) {
            String methodName = TextUtils.isEmpty(injectMethod.methodName()) ? joinPoint.getSignature().getName() : injectMethod.methodName();
            Object[] args = joinPoint.getArgs();
            Method[] methods = targetClass.getMethods();
            getMethod(target, methodName, args, methods);
        }
    }

    private void getMethod(Object target, String methodName, Object[] args, Method[] methods) throws IllegalAccessException, InvocationTargetException {
        for (Method method : methods
                ) {
            if (method.getName().equals(methodName)) {
                Class[] par = method.getParameterTypes();
                if (par.length == 0 && args.length == 0) {
                    method.invoke(target, args);
                    break;
                }
                if (par.length == args.length) {
                    int length = par.length;
                    boolean flag = true;
                    for (int i = 0; i < length; i++) {
                        Class temp = getPrimitiveClass(par[i]);
                        if (!temp.isInstance(args[i])) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        method.invoke(target, args);
                        break;
                    }
                }
            }
        }
    }

    private Object getTarget(ProceedingJoinPoint joinPoint, Constructor<?>[] constructors) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Object target = null;
        for (Constructor<?> constructor : constructors
                ) {
            Class[] par = constructor.getParameterTypes();
            if (par.length == 0) {
                target = constructor.newInstance();
                break;
            } else if (par.length == 1) {
                if (par[0].isInstance(joinPoint.getThis())) {
                    target = constructor.newInstance(joinPoint.getThis());
                    break;
                }
            }
        }
        return target;
    }

    private static Hashtable<Class<?>, Class<?>> prims = new Hashtable<>();

    static {
        prims.put(void.class, Void.class);
        prims.put(boolean.class, Boolean.class);
        prims.put(byte.class, Byte.class);
        prims.put(char.class, Character.class);
        prims.put(short.class, Short.class);
        prims.put(int.class, Integer.class);
        prims.put(long.class, Long.class);
        prims.put(float.class, Float.class);
        prims.put(double.class, Double.class);
    }

    @NonNull
    private Class getPrimitiveClass(Class targetClass) {
        Class<?> result= prims.get(targetClass);
        return result==null?targetClass:result;
    }

//    @After("execution(* com.mvvm.x930073498.BaseViewModelLib.core.ContextToastProvider.**(..))")
//    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
//
//        Log.d(TAG, "onActivityMethodBefore:getKind= " + joinPoint.getKind());
//        Log.d(TAG, "onActivityMethodBefore: getArgs=" + joinPoint.getArgs());
//        Log.d(TAG, "onActivityMethodBefore: getSignature=" + joinPoint.getSignature().getName());
//        Log.d(TAG, "onActivityMethodBefore: getSourceLocation=" + joinPoint.getSourceLocation());
//        Log.d(TAG, "onActivityMethodBefore: getStaticPart=" + joinPoint.getStaticPart());
//        Log.d(TAG, "onActivityMethodBefore:getTarget=" + joinPoint.getTarget());
//        Log.d(TAG, "onActivityMethodBefore: getThis=" + joinPoint.getThis());
//    }
}