/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.cv;
import android.support.v4.app.cw;
import android.support.v4.app.cx;
import android.support.v4.app.cy;
import android.support.v4.app.cz;
import android.support.v4.app.dc;
import android.support.v4.app.dd;

public final class cu
extends dc {
    public static final dd a;
    private static final cw g;
    private final String b;
    private final CharSequence c;
    private final CharSequence[] d;
    private final boolean e;
    private final Bundle f;

    static {
        g = Build.VERSION.SDK_INT >= 20 ? new cx() : (Build.VERSION.SDK_INT >= 16 ? new cz() : new cy());
        a = new cv();
    }

    @Override
    public String a() {
        return this.b;
    }

    @Override
    public CharSequence b() {
        return this.c;
    }

    @Override
    public CharSequence[] c() {
        return this.d;
    }

    @Override
    public boolean d() {
        return this.e;
    }

    @Override
    public Bundle e() {
        return this.f;
    }
}

