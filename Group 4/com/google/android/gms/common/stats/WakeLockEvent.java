/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.stats.h;
import com.google.android.gms.common.stats.j;
import java.util.List;

public final class WakeLockEvent
extends h
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new j();
    final int a;
    private final long b;
    private int c;
    private final String d;
    private final int e;
    private final List f;
    private final String g;
    private final long h;
    private int i;
    private final String j;
    private final String k;
    private final float l;
    private final long m;
    private long n;

    WakeLockEvent(int n2, long l2, int n3, String string, int n4, List list, String string2, long l3, int n5, String string3, String string4, float f2, long l4) {
        this.a = n2;
        this.b = l2;
        this.c = n3;
        this.d = string;
        this.j = string3;
        this.e = n4;
        this.n = -1;
        this.f = list;
        this.g = string2;
        this.h = l3;
        this.i = n5;
        this.k = string4;
        this.l = f2;
        this.m = l4;
    }

    public WakeLockEvent(long l2, int n2, String string, int n3, List list, String string2, long l3, int n4, String string3, String string4, float f2, long l4) {
        this(1, l2, n2, string, n3, list, string2, l3, n4, string3, string4, f2, l4);
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
        return this.j;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public List f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public long h() {
        return this.h;
    }

    @Override
    public long i() {
        return this.n;
    }

    public int j() {
        return this.i;
    }

    public String k() {
        return this.k;
    }

    @Override
    public String l() {
        String string;
        StringBuilder stringBuilder = new StringBuilder().append("\t").append(this.c()).append("\t").append(this.e()).append("\t");
        String string2 = this.f() == null ? "" : TextUtils.join((CharSequence)",", (Iterable)this.f());
        StringBuilder stringBuilder2 = stringBuilder.append(string2).append("\t").append(this.j()).append("\t");
        String string3 = this.d() == null ? "" : this.d();
        StringBuilder stringBuilder3 = stringBuilder2.append(string3).append("\t");
        if (this.k() == null) {
            string = "";
            return stringBuilder3.append(string).append("\t").append(this.m()).toString();
        }
        string = this.k();
        return stringBuilder3.append(string).append("\t").append(this.m()).toString();
    }

    public float m() {
        return this.l;
    }

    public long n() {
        return this.m;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        j.a(this, parcel, n2);
    }
}

