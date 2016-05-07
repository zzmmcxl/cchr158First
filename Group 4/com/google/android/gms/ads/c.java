/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.n;

public final class c {
    public static final c a = new c(320, 50, "320x50_mb");
    public static final c b = new c(468, 60, "468x60_as");
    public static final c c = new c(320, 100, "320x100_as");
    public static final c d = new c(728, 90, "728x90_as");
    public static final c e = new c(300, 250, "300x250_as");
    public static final c f = new c(160, 600, "160x600_as");
    public static final c g = new c(-1, -2, "smart_banner");
    public static final c h = new c(-3, -4, "fluid");
    private final int i;
    private final int j;
    private final String k;

    public c(int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        String string = n2 == -1 ? "FULL" : String.valueOf(n2);
        StringBuilder stringBuilder2 = stringBuilder.append(string).append("x");
        String string2 = n3 == -2 ? "AUTO" : String.valueOf(n3);
        this(n2, n3, stringBuilder2.append(string2).append("_as").toString());
    }

    c(int n2, int n3, String string) {
        if (n2 < 0 && n2 != -1 && n2 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + n2);
        }
        if (n3 < 0 && n3 != -2 && n3 != -4) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + n3);
        }
        this.i = n2;
        this.j = n3;
        this.k = string;
    }

    public int a() {
        return this.j;
    }

    public int a(Context context) {
        switch (this.j) {
            default: {
                return n.a().a(context, this.j);
            }
            case -2: {
                return AdSizeParcel.b(context.getResources().getDisplayMetrics());
            }
            case -4: 
            case -3: 
        }
        return -1;
    }

    public int b() {
        return this.i;
    }

    public int b(Context context) {
        switch (this.i) {
            default: {
                return n.a().a(context, this.i);
            }
            case -1: {
                return AdSizeParcel.a(context.getResources().getDisplayMetrics());
            }
            case -4: 
            case -3: 
        }
        return -1;
    }

    public boolean c() {
        if (this.i != -3) return false;
        if (this.j != -4) return false;
        return true;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        c c2 = (c)object;
        if (this.i != c2.i) return false;
        if (this.j != c2.j) return false;
        if (this.k.equals(c2.k)) return true;
        return false;
    }

    public int hashCode() {
        return this.k.hashCode();
    }

    public String toString() {
        return this.k;
    }
}

