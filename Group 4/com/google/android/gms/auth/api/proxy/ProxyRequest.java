/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new c();
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 7;
    final int j;
    public final String k;
    public final int l;
    public final long m;
    public final byte[] n;
    Bundle o;

    ProxyRequest(int n2, String string, int n3, long l2, byte[] arrby, Bundle bundle) {
        this.j = n2;
        this.k = string;
        this.l = n3;
        this.m = l2;
        this.n = arrby;
        this.o = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.k + ", method: " + this.l + " ]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

