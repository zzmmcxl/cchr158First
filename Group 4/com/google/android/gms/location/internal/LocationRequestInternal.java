/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.z;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal
implements SafeParcelable {
    public static final z CREATOR;
    static final List a;
    LocationRequest b;
    boolean c;
    boolean d;
    boolean e;
    List f;
    String g;
    boolean h;
    private final int i;

    static {
        a = Collections.emptyList();
        CREATOR = new z();
    }

    LocationRequestInternal(int n2, LocationRequest locationRequest, boolean bl2, boolean bl3, boolean bl4, List list, String string, boolean bl5) {
        this.i = n2;
        this.b = locationRequest;
        this.c = bl2;
        this.d = bl3;
        this.e = bl4;
        this.f = list;
        this.g = string;
        this.h = bl5;
    }

    int a() {
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal)object;
        if (!bc.a((Object)this.b, (Object)locationRequestInternal.b)) return false;
        if (this.c != locationRequestInternal.c) return false;
        if (this.d != locationRequestInternal.d) return false;
        if (this.e != locationRequestInternal.e) return false;
        if (this.h != locationRequestInternal.h) return false;
        if (!bc.a((Object)this.f, (Object)locationRequestInternal.f)) return false;
        return true;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.toString());
        if (this.g != null) {
            stringBuilder.append(" tag=").append(this.g);
        }
        stringBuilder.append(" nlpDebug=").append(this.c);
        stringBuilder.append(" trigger=").append(this.e);
        stringBuilder.append(" restorePIListeners=").append(this.d);
        stringBuilder.append(" hideAppOps=").append(this.h);
        stringBuilder.append(" clients=").append(this.f);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        z.a(this, parcel, n2);
    }
}

