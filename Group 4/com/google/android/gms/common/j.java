/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.common.r;

public class j {
    private static final j a;
    public static final int b;

    static {
        b = r.b;
        a = new j();
    }

    j() {
    }

    public static j b() {
        return a;
    }

    private String b(Context context, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            stringBuilder.append(string);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context == null) return stringBuilder.toString();
        try {
            stringBuilder.append(context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode);
        }
        catch (PackageManager.NameNotFoundException var9_4) {
            return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

    public int a(Context context) {
        int n2 = r.a(context);
        if (!r.c(context, n2)) return n2;
        return 18;
    }

    public Intent a(Context context, int n2, String string) {
        switch (n2) {
            default: {
                return null;
            }
            case 1: 
            case 2: {
                return ao.a("com.google.android.gms", this.b(context, string));
            }
            case 42: {
                return ao.a();
            }
            case 3: 
        }
        return ao.a("com.google.android.gms");
    }

    public boolean a(int n2) {
        return r.b(n2);
    }

    public boolean a(Context context, int n2) {
        return r.c(context, n2);
    }

    public boolean a(Context context, String string) {
        return r.a(context, string);
    }

    @Deprecated
    public Intent b(int n2) {
        return this.a(null, n2, null);
    }

    public void b(Context context) {
        r.b(context);
    }

    public void c(Context context) {
        r.c(context);
    }
}

