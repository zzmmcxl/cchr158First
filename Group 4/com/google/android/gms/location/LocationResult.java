/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.z;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR;
    static final List a;
    private final int b;
    private final List c;

    static {
        a = Collections.emptyList();
        CREATOR = new z();
    }

    LocationResult(int n2, List list) {
        this.b = n2;
        this.c = list;
    }

    public List a() {
        return this.c;
    }

    int b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Location location;
        Location location2;
        if (!(object instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult)object;
        if (locationResult.c.size() != this.c.size()) {
            return false;
        }
        Iterator iterator = locationResult.c.iterator();
        Iterator iterator2 = this.c.iterator();
        do {
            if (!iterator.hasNext()) return true;
            location2 = (Location)iterator2.next();
            location = (Location)iterator.next();
        } while (location2.getTime() == location.getTime());
        return false;
    }

    public int hashCode() {
        Iterator iterator = this.c.iterator();
        int n2 = 17;
        while (iterator.hasNext()) {
            long l2 = ((Location)iterator.next()).getTime();
            n2 = (int)(l2 ^ l2 >>> 32) + n2 * 31;
        }
        return n2;
    }

    public String toString() {
        return "LocationResult[locations: " + this.c + "]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        z.a(this, parcel, n2);
    }
}

