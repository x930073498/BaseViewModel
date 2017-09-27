package com.mvvm.x930073498.BaseViewModelLib.core;

/**
 * Created by x930073498 on 2017/9/28.
 */

public interface MapProvider extends BaseProvider {
    void put(Class<? extends BaseProvider> key, BaseProvider value);

    BaseProvider get(Class<? extends BaseProvider> key);
}
