/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.internal.formats.a;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public class NativeAdOptionsParcel
implements SafeParcelable {
    public static final a CREATOR = new a();
    public final int a;
    public final boolean b;
    public final int c;
    public final boolean d;

    public NativeAdOptionsParcel(int n2, boolean bl2, int n3, boolean bl3) {
        this.a = n2;
        this.b = bl2;
        this.c = n3;
        this.d = bl3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

