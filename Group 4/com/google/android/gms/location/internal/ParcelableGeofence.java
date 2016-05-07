/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.e;
import com.google.android.gms.location.internal.ab;
import java.util.Locale;

public class ParcelableGeofence
implements SafeParcelable,
e {
    public static final ab CREATOR = new ab();
    private final int a;
    private final String b;
    private final long c;
    private final short d;
    private final double e;
    private final double f;
    private final float g;
    private final int h;
    private final int i;
    private final int j;

    public ParcelableGeofence(int n2, String string, int n3, short s2, double d2, double d3, float f2, long l2, int n4, int n5) {
        ParcelableGeofence.a(string);
        ParcelableGeofence.a(f2);
        ParcelableGeofence.a(d2, d3);
        int n6 = ParcelableGeofence.a(n3);
        this.a = n2;
        this.d = s2;
        this.b = string;
        this.e = d2;
        this.f = d3;
        this.g = f2;
        this.c = l2;
        this.h = n6;
        this.i = n4;
        this.j = n5;
    }

    public ParcelableGeofence(String string, int n2, short s2, double d2, double d3, float f2, long l2, int n3, int n4) {
        this(1, string, n2, s2, d2, d3, f2, l2, n3, n4);
    }

    private static int a(int n2) {
        int n3 = n2 & 7;
        if (n3 != 0) return n3;
        throw new IllegalArgumentException("No supported transition specified: " + n2);
    }

    public static ParcelableGeofence a(byte[] arrby) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(arrby, 0, arrby.length);
        parcel.setDataPosition(0);
        ParcelableGeofence parcelableGeofence = CREATOR.a(parcel);
        parcel.recycle();
        return parcelableGeofence;
    }

    private static void a(double d2, double d3) {
        if (d2 > 90.0) throw new IllegalArgumentException("invalid latitude: " + d2);
        if (d2 < -90.0) {
            throw new IllegalArgumentException("invalid latitude: " + d2);
        }
        if (d3 > 180.0) throw new IllegalArgumentException("invalid longitude: " + d3);
        if (d3 >= -180.0) return;
        throw new IllegalArgumentException("invalid longitude: " + d3);
    }

    private static void a(float f2) {
        if (f2 > 0.0f) return;
        throw new IllegalArgumentException("invalid radius: " + f2);
    }

    private static void a(String string) {
        if (string == null) throw new IllegalArgumentException("requestId is null or too long: " + string);
        if (string.length() <= 100) return;
        throw new IllegalArgumentException("requestId is null or too long: " + string);
    }

    @SuppressLint(value={"DefaultLocale"})
    private static String b(int n2) {
        switch (n2) {
            default: {
                return null;
            }
            case 1: 
        }
        return "CIRCLE";
    }

    @Override
    public String a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public short c() {
        return this.d;
    }

    public double d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public double e() {
        return this.f;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ParcelableGeofence)) {
            return false;
        }
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence)object;
        if (this.g != parcelableGeofence.g) {
            return false;
        }
        if (this.e != parcelableGeofence.e) {
            return false;
        }
        if (this.f != parcelableGeofence.f) {
            return false;
        }
        if (this.d == parcelableGeofence.d) return true;
        return false;
    }

    public float f() {
        return this.g;
    }

    public long g() {
        return this.c;
    }

    public int h() {
        return this.h;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.e);
        int n2 = 31 + (int)(l2 ^ l2 >>> 32);
        long l3 = Double.doubleToLongBits(this.f);
        return 31 * (31 * (31 * (n2 * 31 + (int)(l3 ^ l3 >>> 32)) + Float.floatToIntBits(this.g)) + this.d) + this.h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{ParcelableGeofence.b(this.d), this.b, this.h, this.e, this.f, Float.valueOf(this.g), this.i / 1000, this.j, this.c};
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", arrobject);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ab.a(this, parcel, n2);
    }
}

