/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.e;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public final class SearchAdRequestParcel
implements SafeParcelable {
    public static final e CREATOR = new e();
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final int k;
    public final String l;
    public final int m;
    public final int n;
    public final String o;

    SearchAdRequestParcel(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, String string, int n11, String string2, int n12, int n13, String string3) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = n5;
        this.e = n6;
        this.f = n7;
        this.g = n8;
        this.h = n9;
        this.i = n10;
        this.j = string;
        this.k = n11;
        this.l = string2;
        this.m = n12;
        this.n = n13;
        this.o = string3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }
}

