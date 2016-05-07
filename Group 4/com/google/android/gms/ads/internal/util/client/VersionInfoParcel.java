/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.util.client.c;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public final class VersionInfoParcel
implements SafeParcelable {
    public static final c CREATOR = new c();
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    VersionInfoParcel(int n2, String string, int n3, int n4, boolean bl2) {
        this.a = n2;
        this.b = string;
        this.c = n3;
        this.d = n4;
        this.e = bl2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

