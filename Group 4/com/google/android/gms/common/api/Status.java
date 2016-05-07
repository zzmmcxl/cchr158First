/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.be;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status
implements w,
SafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final Status a;
    public static final Status b;
    public static final Status c;
    public static final Status d;
    public static final Status e;
    private final int f;
    private final int g;
    private final String h;
    private final PendingIntent i;

    static {
        a = new Status(0);
        b = new Status(14);
        c = new Status(8);
        d = new Status(15);
        e = new Status(16);
        CREATOR = new ad();
    }

    public Status(int n2) {
        this(n2, null);
    }

    Status(int n2, int n3, String string, PendingIntent pendingIntent) {
        this.f = n2;
        this.g = n3;
        this.h = string;
        this.i = pendingIntent;
    }

    public Status(int n2, String string) {
        this(1, n2, string, null);
    }

    public Status(int n2, String string, PendingIntent pendingIntent) {
        this(1, n2, string, pendingIntent);
    }

    private String g() {
        if (this.h == null) return m.a(this.g);
        return this.h;
    }

    @Override
    public Status a() {
        return this;
    }

    PendingIntent b() {
        return this.i;
    }

    public String c() {
        return this.h;
    }

    int d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        if (this.g > 0) return false;
        return true;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Status)) {
            return false;
        }
        Status status = (Status)object;
        if (this.f != status.f) return false;
        if (this.g != status.g) return false;
        if (!bc.a((Object)this.h, (Object)status.h)) return false;
        if (!bc.a((Object)this.i, (Object)status.i)) return false;
        return true;
    }

    public int f() {
        return this.g;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.f, this.g, this.h, this.i};
        return bc.a(arrobject);
    }

    public String toString() {
        return bc.a((Object)this).a("statusCode", this.g()).a("resolution", (Object)this.i).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ad.a(this, parcel, n2);
    }
}

