/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.h;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.b.ja;
import com.google.android.gms.b.jb;
import com.google.android.gms.b.jd;
import com.google.android.gms.common.internal.bf;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class jc
extends jb {
    public static final List c = Collections.singletonList("email");
    private Class d;
    private Class e;
    private Object f;
    private Object g;

    public jc(Activity activity, List list) {
        super(activity, c, list);
    }

    static /* synthetic */ Intent a(jc jc2, IdpTokenType idpTokenType, String string, String string2) {
        return jc2.a(idpTokenType, string, string2);
    }

    static /* synthetic */ String a(jc jc2) {
        return jc2.d();
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static void a(Context var0) {
        bf.a((Object)var0);
        try {
            var8_1 = Class.forName("com.facebook.FacebookSdk");
            try {
                var11_2 = new Class[]{Context.class, Integer.TYPE};
                var12_3 = var8_1.getDeclaredMethod("sdkInitialize", var11_2);
                var13_4 = new Object[]{var0.getApplicationContext(), 64206};
                var12_3.invoke(null, var13_4);
                var15_5 = Class.forName("com.facebook.login.LoginManager");
                var16_6 = var15_5.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                var15_5.getDeclaredMethod("logOut", new Class[0]).invoke(var16_6, new Object[0]);
                return;
            }
            catch (NoSuchMethodException var9_7) {}
            ** GOTO lbl-1000
        }
        catch (ClassNotFoundException var2_11) {
            try {
                var5_12 = Class.forName("com.facebook.Session");
                var6_13 = var5_12.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                if (var6_13 == null) return;
                var5_12.getDeclaredMethod("closeAndClearTokenInformation", new Class[0]).invoke(var6_13, new Object[0]);
                return;
            }
            catch (ClassNotFoundException var3_14) {}
            ** GOTO lbl-1000
            catch (NoSuchMethodException var3_16) {
                ** GOTO lbl-1000
            }
            catch (IllegalAccessException var3_17) {
                ** GOTO lbl-1000
            }
            catch (InvocationTargetException var3_18) {}
lbl-1000: // 4 sources:
            {
                Log.e((String)"AuthSignInClient", (String)"Facebook logout error.", (Throwable)var3_15);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        }
        catch (IllegalAccessException var9_9) {
            ** GOTO lbl-1000
        }
        catch (InvocationTargetException var9_10) {}
lbl-1000: // 3 sources:
        {
            Log.e((String)"AuthSignInClient", (String)"Facebook logout error.", (Throwable)var9_8);
            throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
        }
    }

    static /* synthetic */ ja b(jc jc2) {
        return jc2.c();
    }

    private void e() {
        if (this.g != null) {
            Method method = Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", Activity.class, Collection.class);
            Object object = this.g;
            Object[] arrobject = new Object[]{this.a, new ArrayList(this.b())};
            method.invoke(object, arrobject);
            return;
        }
        Class class_ = Class.forName("com.facebook.Session$OpenRequest");
        Constructor constructor = class_.getConstructor(Activity.class);
        Object[] arrobject = new Object[]{this.a};
        Object obj = constructor.newInstance(arrobject);
        Method method = class_.getDeclaredMethod("setPermissions", List.class);
        Object[] arrobject2 = new Object[]{new ArrayList(this.b())};
        method.invoke(obj, arrobject2);
        Class[] arrclass = new Class[]{Integer.TYPE};
        Method method2 = class_.getDeclaredMethod("setRequestCode", arrclass);
        Object[] arrobject3 = new Object[]{64206};
        method2.invoke(obj, arrobject3);
        Class class_2 = Class.forName("com.facebook.Session");
        Method method3 = class_.getDeclaredMethod("setCallback", Class.forName("com.facebook.Session$StatusCallback"));
        Object[] arrobject4 = new Object[]{this.f()};
        method3.invoke(obj, arrobject4);
        Constructor constructor2 = class_2.getConstructor(Context.class);
        Object[] arrobject5 = new Object[]{this.a};
        Object obj2 = constructor2.newInstance(arrobject5);
        class_2.getDeclaredMethod("setActiveSession", class_2).invoke(null, obj2);
        class_2.getDeclaredMethod("openForRead", class_).invoke(obj2, obj);
    }

    private Object f() {
        Class class_ = Class.forName("com.facebook.Session");
        Class class_2 = Class.forName("com.facebook.Session$StatusCallback");
        return Proxy.newProxyInstance(class_2.getClassLoader(), new Class[]{class_2}, new jd(this, class_));
    }

    @Override
    public h a() {
        return h.b;
    }

    @Override
    public void a(ja ja2) {
        void var2_3;
        this.b(null, null, (ja)bf.a(ja2));
        try {
            this.e();
            return;
        }
        catch (ClassNotFoundException var2_2) {
            throw new RuntimeException((Throwable)var2_3);
        }
        catch (NoSuchMethodException var2_4) {
            throw new RuntimeException((Throwable)var2_3);
        }
        catch (IllegalAccessException var2_5) {
            throw new RuntimeException((Throwable)var2_3);
        }
        catch (InvocationTargetException var2_6) {
            throw new RuntimeException((Throwable)var2_3);
        }
        catch (InstantiationException var2_7) {
            throw new RuntimeException((Throwable)var2_3);
        }
    }

    @Override
    public void a(String string, ja ja2) {
        void var3_4;
        this.b((String)bf.a((Object)string), null, (ja)bf.a(ja2));
        try {
            this.e();
            return;
        }
        catch (ClassNotFoundException var3_3) {
            throw new RuntimeException((Throwable)var3_4);
        }
        catch (NoSuchMethodException var3_5) {
            throw new RuntimeException((Throwable)var3_4);
        }
        catch (IllegalAccessException var3_6) {
            throw new RuntimeException((Throwable)var3_4);
        }
        catch (InvocationTargetException var3_7) {
            throw new RuntimeException((Throwable)var3_4);
        }
        catch (InstantiationException var3_8) {
            throw new RuntimeException((Throwable)var3_4);
        }
    }

    @Override
    public void a(String string, String string2, ja ja2) {
        void var4_5;
        this.b((String)bf.a((Object)string), (String)bf.a((Object)string2), (ja)bf.a(ja2));
        try {
            this.e();
            return;
        }
        catch (ClassNotFoundException var4_4) {
            throw new RuntimeException((Throwable)var4_5);
        }
        catch (NoSuchMethodException var4_6) {
            throw new RuntimeException((Throwable)var4_5);
        }
        catch (IllegalAccessException var4_7) {
            throw new RuntimeException((Throwable)var4_5);
        }
        catch (InvocationTargetException var4_8) {
            throw new RuntimeException((Throwable)var4_5);
        }
        catch (InstantiationException var4_9) {
            throw new RuntimeException((Throwable)var4_5);
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    public boolean a(int n2, int n3, Intent intent, ja ja2) {
        void var12_16;
        void var5_26;
        this.b(ja2);
        if (n2 != 64206 && this.d == null) {
            return false;
        }
        if (this.d != null && this.e != null && this.f != null) {
            try {
                Class class_ = this.d;
                Class[] arrclass = new Class[]{Integer.TYPE};
                Method method = class_.getDeclaredMethod("isFacebookRequestCode", arrclass);
                Object[] arrobject = new Object[]{n2};
                if (!((Boolean)method.invoke(null, arrobject)).booleanValue()) {
                    return false;
                }
                Class class_2 = this.e;
                Class[] arrclass2 = new Class[]{Integer.TYPE, Integer.TYPE, Intent.class};
                Method method2 = class_2.getDeclaredMethod("onActivityResult", arrclass2);
                Object object = this.f;
                Object[] arrobject2 = new Object[]{n2, n3, intent};
                return (Boolean)method2.invoke(object, arrobject2);
            }
            catch (NoSuchMethodException var12_15) {
                throw new RuntimeException((Throwable)var12_16);
            }
        }
        try {
            Class class_ = Class.forName("com.facebook.Session");
            Object object = class_.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
            Class[] arrclass = new Class[]{Activity.class, Integer.TYPE, Integer.TYPE, Intent.class};
            Method method = class_.getDeclaredMethod("onActivityResult", arrclass);
            if (object == null) {
                return false;
            }
            Object[] arrobject = new Object[]{this.a, n2, n3, intent};
            return (Boolean)method.invoke(object, arrobject);
        }
        catch (NoSuchMethodException var5_25) {
            throw new RuntimeException((Throwable)var5_26);
        }
        catch (ClassNotFoundException var5_27) {
            throw new RuntimeException((Throwable)var5_26);
        }
        catch (IllegalAccessException var5_28) {
            throw new RuntimeException((Throwable)var5_26);
        }
        catch (InvocationTargetException var5_29) {
            throw new RuntimeException((Throwable)var5_26);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException((Throwable)var12_16);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException((Throwable)var12_16);
        }
    }
}

