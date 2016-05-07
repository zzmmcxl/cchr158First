/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.e;

import android.os.Build;
import android.os.Parcelable;
import android.support.v4.e.e;
import android.support.v4.e.f;
import android.support.v4.e.h;

public final class d {
    public static Parcelable.Creator a(f f2) {
        if (Build.VERSION.SDK_INT < 13) return new e(f2);
        return h.a(f2);
    }
}

