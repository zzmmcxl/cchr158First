/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyGrpcRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new b();
    final int a;
    public final String b;
    public final int c;
    public final long d;
    public final byte[] e;
    public final String f;

    ProxyGrpcRequest(int n2, String string, int n3, long l2, byte[] arrby, String string2) {
        this.a = n2;
        this.b = string;
        this.c = n3;
        this.d = l2;
        this.e = arrby;
        this.f = string2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

