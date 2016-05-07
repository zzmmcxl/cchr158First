/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.stats.a;
import com.google.android.gms.common.stats.h;

public final class ConnectionEvent
extends h
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new a();
    final int a;
    private final long b;
    private int c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final long j;
    private final long k;
    private long l;

    ConnectionEvent(int n2, long l2, int n3, String string, String string2, String string3, String string4, String string5, String string6, long l3, long l4) {
        this.a = n2;
        this.b = l2;
        this.c = n3;
        this.d = string;
        this.e = string2;
        this.f = string3;
        this.g = string4;
        this.l = -1;
        this.h = string5;
        this.i = string6;
        this.j = l3;
        this.k = l4;
    }

    public ConnectionEvent(long l2, int n2, String string, String string2, String string3, String string4, String string5, String string6, long l3, long l4) {
        this(1, l2, n2, string, string2, string3, string4, string5, string6, l3, l4);
    }

    @Override
    public long a() {
        return this.b;
    }

    @Override
    public int b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    @Override
    public long i() {
        return this.l;
    }

    public long j() {
        return this.k;
    }

    public long k() {
        return this.j;
    }

    @Override
    public String l() {
        String string;
        StringBuilder stringBuilder = new StringBuilder().append("\t").append(this.c()).append("/").append(this.d()).append("\t").append(this.e()).append("/").append(this.f()).append("\t");
        if (this.h == null) {
            string = "";
            return stringBuilder.append(string).append("\t").append(this.j()).toString();
        }
        string = this.h;
        return stringBuilder.append(string).append("\t").append(this.j()).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

