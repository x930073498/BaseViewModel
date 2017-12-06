package com.mvvm.x930073498.BaseViewModelLib.core.annotation;

import com.mvvm.x930073498.BaseViewModelLib.core.BaseProvider;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by x930073498 on 2017/12/6.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Inherited
@Documented
public @interface InjectBefore {
    Class<? extends BaseProvider> source();
}
