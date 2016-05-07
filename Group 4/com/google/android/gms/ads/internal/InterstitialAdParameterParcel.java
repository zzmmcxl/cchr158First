/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public final class InterstitialAdParameterParcel
implements SafeParcelable {
    public static final e CREATOR = new e();
    public final int a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final float f;

    InterstitialAdParameterParcel(int n2, boolean bl2, boolean bl3, String string, boolean bl4, float f2) {
        this.a = n2;
        this.b = bl2;
        this.c = bl3;
        this.d = string;
        this.e = bl4;
        this.f = f2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }
}

