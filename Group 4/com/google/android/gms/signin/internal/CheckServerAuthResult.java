/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.c;
import java.util.List;

public class CheckServerAuthResult
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new c();
    final int a;
    final boolean b;
    final List c;

    CheckServerAuthResult(int n2, boolean bl2, List list) {
        this.a = n2;
        this.b = bl2;
        this.c = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

