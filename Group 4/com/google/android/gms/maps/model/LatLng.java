/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.b;

public final class LatLng
implements SafeParcelable {
    public static final b CREATOR = new b();
    public final double a;
    public final double b;
    private final int c;

    public LatLng(double d2, double d3) {
        this(1, d2, d3);
    }

    LatLng(int n2, double d2, double d3) {
        this.c = n2;
        this.b = -180.0 <= d3 && d3 < 180.0 ? d3 : (360.0 + (d3 - 180.0) % 360.0) % 360.0 - 180.0;
        this.a = Math.max(-90.0, Math.min(90.0, d2));
    }

    int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng)object;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(latLng.a)) return false;
        if (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLng.b)) return true;
        return false;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.a);
        int n2 = 31 + (int)(l2 ^ l2 >>> 32);
        long l3 = Double.doubleToLongBits(this.b);
        return n2 * 31 + (int)(l3 ^ l3 >>> 32);
    }

    public String toString() {
        return "lat/lng: (" + this.a + "," + this.b + ")";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

