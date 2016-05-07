/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.support.v4.b.h;
import android.support.v4.b.i;
import android.support.v4.b.j;
import android.support.v4.b.k;

public final class g {
    private static final h a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 15) {
            a = new k();
            return;
        }
        if (n2 >= 11) {
            a = new j();
            return;
        }
        a = new i();
    }

    public static Intent a(ComponentName componentName) {
        return a.a(componentName);
    }
}

