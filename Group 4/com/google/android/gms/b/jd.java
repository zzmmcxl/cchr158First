/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.b.jc;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class jd
implements InvocationHandler {
    final /* synthetic */ Class a;
    final /* synthetic */ jc b;

    jd(jc jc2, Class class_) {
        this.b = jc2;
        this.a = class_;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] arrobject) {
        Class class_ = Class.forName("com.facebook.SessionState");
        Class<?>[] arrclass = method.getParameterTypes();
        if (!method.getName().equals("call")) throw new ExceptionInInitializerError("Method not supported!");
        if (arrclass.length != 3) throw new ExceptionInInitializerError("Method not supported!");
        if (arrclass[0] != this.a) throw new ExceptionInInitializerError("Method not supported!");
        if (arrclass[1] != class_) throw new ExceptionInInitializerError("Method not supported!");
        if (arrclass[2] != Exception.class) {
            throw new ExceptionInInitializerError("Method not supported!");
        }
        if ((Boolean)this.a.getDeclaredMethod("isOpened", new Class[0]).invoke(arrobject[0], new Object[0]) == false) return null;
        String string = (String)this.a.getDeclaredMethod("getAccessToken", new Class[0]).invoke(arrobject[0], new Object[0]);
        jc.b(this.b).a(jc.a(this.b, IdpTokenType.a, string, jc.a(this.b)));
        return null;
    }
}

