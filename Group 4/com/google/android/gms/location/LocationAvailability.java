/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.k;

public final class LocationAvailability
implements SafeParcelable {
    public static final k CREATOR = new k();
    int a;
    int b;
    long c;
    int d;
    private final int e;

    LocationAvailability(int n2, int n3, int n4, int n5, long l2) {
        this.e = n2;
        this.d = n3;
        this.a = n4;
        this.b = n5;
        this.c = l2;
    }

    public boolean a() {
        if (this.d >= 1000) return false;
        return true;
    }

    int b() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability)object;
        if (this.d != locationAvailability.d) return false;
        if (this.a != locationAvailability.a) return false;
        if (this.b != locationAvailability.b) return false;
        if (this.c != locationAvailability.c) return false;
        return true;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.d, this.a, this.b, this.c};
        return bc.a(arrobject);
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + this.a() + "]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.a(this, parcel, n2);
    }
}

