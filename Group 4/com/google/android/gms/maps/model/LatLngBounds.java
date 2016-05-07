/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.be;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.a;

public final class LatLngBounds
implements SafeParcelable {
    public static final a CREATOR = new a();
    public final LatLng a;
    public final LatLng b;
    private final int c;

    LatLngBounds(int n2, LatLng latLng, LatLng latLng2) {
        bf.a(latLng, (Object)"null southwest");
        bf.a(latLng2, (Object)"null northeast");
        boolean bl2 = latLng2.a >= latLng.a;
        Object[] arrobject = new Object[]{latLng.a, latLng2.a};
        bf.b(bl2, "southern latitude exceeds northern latitude (%s > %s)", arrobject);
        this.c = n2;
        this.a = latLng;
        this.b = latLng2;
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
        if (!(object instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds)object;
        if (!this.a.equals(latLngBounds.a)) return false;
        if (this.b.equals(latLngBounds.b)) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.a, this.b};
        return bc.a(arrobject);
    }

    public String toString() {
        return bc.a((Object)this).a("southwest", this.a).a("northeast", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

