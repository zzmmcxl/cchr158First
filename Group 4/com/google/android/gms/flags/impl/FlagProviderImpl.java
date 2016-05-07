/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.a.a;
import com.google.android.gms.b.kw;
import com.google.android.gms.flags.impl.b;
import com.google.android.gms.flags.impl.d;
import com.google.android.gms.flags.impl.f;
import com.google.android.gms.flags.impl.h;
import com.google.android.gms.flags.impl.j;

public class FlagProviderImpl
extends kw {
    private boolean a = false;
    private SharedPreferences b;

    @Override
    public boolean getBooleanFlagValue(String string, boolean bl2, int n2) {
        return b.a(this.b, string, bl2);
    }

    @Override
    public int getIntFlagValue(String string, int n2, int n3) {
        return d.a(this.b, string, n2);
    }

    @Override
    public long getLongFlagValue(String string, long l2, int n2) {
        return f.a(this.b, string, l2);
    }

    @Override
    public String getStringFlagValue(String string, String string2, int n2) {
        return h.a(this.b, string, string2);
    }

    @Override
    public void init(a a2) {
        Context context = (Context)com.google.android.gms.a.d.a(a2);
        if (this.a) {
            return;
        }
        try {
            this.b = j.a(context.createPackageContext("com.google.android.gms", 0));
            this.a = true;
            return;
        }
        catch (PackageManager.NameNotFoundException var3_3) {
            return;
        }
    }
}

