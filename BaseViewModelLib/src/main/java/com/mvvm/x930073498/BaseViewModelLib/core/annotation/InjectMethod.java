package com.mvvm.x930073498.BaseViewModelLib.core.annotation;

import android.content.Context;

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
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface InjectMethod {
    Class<? extends BaseProvider> value();

    String methodName() default "";

    Class<?>[] constructorType() default Context.class;

}
