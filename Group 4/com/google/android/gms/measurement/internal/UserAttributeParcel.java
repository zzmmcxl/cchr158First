/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.ae;
import com.google.android.gms.measurement.internal.af;

public class UserAttributeParcel
implements SafeParcelable {
    public static final ae CREATOR = new ae();
    public final int a;
    public final String b;
    public final long c;
    public final Long d;
    public final Float e;
    public final String f;
    public final String g;

    UserAttributeParcel(int n2, String string, long l2, Long l3, Float f2, String string2, String string3) {
        this.a = n2;
        this.b = string;
        this.c = l2;
        this.d = l3;
        this.e = f2;
        this.f = string2;
        this.g = string3;
    }

    UserAttributeParcel(af af2) {
        this(af2.b, af2.c, af2.d, af2.a);
    }

    UserAttributeParcel(String string, long l2, Object object, String string2) {
        bf.a(string);
        this.a = 1;
        this.b = string;
        this.c = l2;
        this.g = string2;
        if (object == null) {
            this.d = null;
            this.e = null;
            this.f = null;
            return;
        }
        if (object instanceof Long) {
            this.d = (Long)object;
            this.e = null;
            this.f = null;
            return;
        }
        if (object instanceof Float) {
            this.d = null;
            this.e = (Float)object;
            this.f = null;
            return;
        }
        if (!(object instanceof String)) throw new IllegalArgumentException("User attribute given of un-supported type");
        this.d = null;
        this.e = null;
        this.f = (String)object;
    }

    public Object a() {
        if (this.d != null) {
            return this.d;
        }
        if (this.e != null) {
            return this.e;
        }
        if (this.f == null) return null;
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ae.a(this, parcel, n2);
    }
}

