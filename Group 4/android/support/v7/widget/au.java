/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.g.g;

class au
extends g {
    public au(int n2) {
        super(n2);
    }

    private static int b(int n2, PorterDuff.Mode mode) {
        return 31 * (n2 + 31) + mode.hashCode();
    }

    PorterDuffColorFilter a(int n2, PorterDuff.Mode mode) {
        return (PorterDuffColorFilter)this.a((Object)au.b(n2, mode));
    }

    PorterDuffColorFilter a(int n2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter)this.a(au.b(n2, mode), (Object)porterDuffColorFilter);
    }
}

