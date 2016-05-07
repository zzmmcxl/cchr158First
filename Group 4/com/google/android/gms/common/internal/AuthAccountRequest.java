/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new e();
    final int a;
    final IBinder b;
    final Scope[] c;
    Integer d;
    Integer e;

    AuthAccountRequest(int n2, IBinder iBinder, Scope[] arrscope, Integer n3, Integer n4) {
        this.a = n2;
        this.b = iBinder;
        this.c = arrscope;
        this.d = n3;
        this.e = n4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }
}

