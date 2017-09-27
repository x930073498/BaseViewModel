package com.mvvm.x930073498.BaseViewModelLib.core;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.widget.Toast;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by x930073498 on 2017/9/27.
 */

public class MapProviderInvocationHandler implements InvocationHandler, MapProvider {
    private static final String TAG = "ContextToast";
    private MapProvider provider;
    private static Toast toast;
    private ArrayMap<Class<? extends BaseProvider>, BaseProvider> map = new ArrayMap<>();

    private MapProviderInvocationHandler(Context context, MapProvider provider) {
        this.provider = provider;
        if (toast == null)
            toast = Toast.makeText(context.getApplicationContext(), "init", Toast.LENGTH_SHORT);
    }

    public static  MapProviderInvocationHandler create(Context context, MapProvider provider) {
        return new MapProviderInvocationHandler(context, provider);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = method.invoke(objects, objects);
        if ("put".equals(method.getName())) {
            if (objects[0] != null)
                put((Class<? extends BaseProvider>) objects[0],(BaseProvider) objects[1]);
            return result;
        } else {
            return get((Class<? extends BaseProvider>) objects[0]);
        }
    }


    @Override
    public void put(Class<? extends BaseProvider> key, BaseProvider value) {
        map.put(key, value);
    }

    @Override
    public BaseProvider get(Class<? extends BaseProvider> key) {
        return map.get(key);
    }
}
