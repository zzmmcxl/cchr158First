/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import java.lang.reflect.Method;

@fi
public class b {
    Object a;
    private final Context b;
    private final boolean c;

    public b(Context context) {
        this(context, true);
    }

    public b(Context context, boolean bl2) {
        this.b = context;
        this.c = bl2;
    }

    public Bundle a(String string, String string2, String string3) {
        try {
            Class class_ = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            Class[] arrclass = new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class};
            Method method = class_.getDeclaredMethod("getBuyIntent", arrclass);
            Object obj = class_.cast(this.a);
            Object[] arrobject = new Object[]{3, string, string2, "inapp", string3};
            return (Bundle)method.invoke(obj, arrobject);
        }
        catch (Exception var4_10) {
            if (!this.c) return null;
            fp.c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var4_10);
            return null;
        }
    }

    public void a() {
        this.a = null;
    }

    public void a(IBinder iBinder) {
        try {
            this.a = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, new Object[]{iBinder});
            return;
        }
        catch (Exception var2_2) {
            if (!this.c) return;
            fp.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            return;
        }
    }
}

