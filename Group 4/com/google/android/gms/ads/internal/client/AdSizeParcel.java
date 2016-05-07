/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.h;
import com.google.android.gms.ads.internal.client.j;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public class AdSizeParcel
implements SafeParcelable {
    public static final j CREATOR = new j();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final AdSizeParcel[] h;
    public final boolean i;
    public final boolean j;
    public boolean k;

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    AdSizeParcel(int n2, String string, int n3, int n4, boolean bl2, int n5, int n6, AdSizeParcel[] arradSizeParcel, boolean bl3, boolean bl4, boolean bl5) {
        this.a = n2;
        this.b = string;
        this.c = n3;
        this.d = n4;
        this.e = bl2;
        this.f = n5;
        this.g = n6;
        this.h = arradSizeParcel;
        this.i = bl3;
        this.j = bl4;
        this.k = bl5;
    }

    public AdSizeParcel(Context context, c c2) {
        this(context, new c[]{c2});
    }

    public AdSizeParcel(Context context, c[] arrc) {
        int n2;
        c c2 = arrc[0];
        this.a = 5;
        this.e = false;
        this.j = c2.c();
        if (this.j) {
            this.f = c.a.b();
            this.c = c.a.a();
        } else {
            this.f = c2.b();
            this.c = c2.a();
        }
        boolean bl2 = this.f == -1;
        boolean bl3 = this.c == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (bl2) {
            this.g = n.a().a(context) && n.a().b(context) ? AdSizeParcel.a(displayMetrics) - n.a().c(context) : AdSizeParcel.a(displayMetrics);
            double d2 = (float)this.g / displayMetrics.density;
            int n3 = (int)d2;
            if (d2 - (double)((int)d2) >= 0.01) {
                ++n3;
            }
            n2 = n3;
        } else {
            int n4 = this.f;
            this.g = n.a().a(displayMetrics, this.f);
            n2 = n4;
        }
        int n5 = bl3 ? AdSizeParcel.c(displayMetrics) : this.c;
        this.d = n.a().a(displayMetrics, n5);
        this.b = bl2 || bl3 ? "" + n2 + "x" + n5 + "_as" : (this.j ? "320x50_mb" : c2.toString());
        if (arrc.length > 1) {
            this.h = new AdSizeParcel[arrc.length];
            for (int i2 = 0; i2 < arrc.length; ++i2) {
                this.h[i2] = new AdSizeParcel(context, arrc[i2]);
            }
        } else {
            this.h = null;
        }
        this.i = false;
        this.k = false;
    }

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int)((float)AdSizeParcel.c(displayMetrics) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int n2 = (int)((float)displayMetrics.heightPixels / displayMetrics.density);
        if (n2 <= 400) {
            return 32;
        }
        if (n2 > 720) return 90;
        return 50;
    }

    public c a() {
        return h.a(this.f, this.c, this.b);
    }

    public void a(boolean bl2) {
        this.k = bl2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        j.a(this, parcel, n2);
    }
}

