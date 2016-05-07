/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.a.f;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.r;

public abstract class e {
    private final String a;
    private Object b;

    protected e(String string) {
        this.a = string;
    }

    protected final Object a(Context context) {
        if (this.b != null) return this.b;
        bf.a((Object)context);
        Context context2 = r.e(context);
        if (context2 == null) {
            throw new f("Could not get remote context.");
        }
        ClassLoader classLoader = context2.getClassLoader();
        try {
            this.b = this.b((IBinder)classLoader.loadClass(this.a).newInstance());
            return this.b;
        }
        catch (ClassNotFoundException var7_4) {
            throw new f("Could not load creator class.", var7_4);
        }
        catch (InstantiationException var6_5) {
            throw new f("Could not instantiate creator.", var6_5);
        }
        catch (IllegalAccessException var5_6) {
            throw new f("Could not access creator.", var5_6);
        }
    }

    protected abstract Object b(IBinder var1);
}

