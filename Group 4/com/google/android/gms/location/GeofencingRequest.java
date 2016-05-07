/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.i;
import com.google.android.gms.location.r;
import java.util.List;

public class GeofencingRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new r();
    private final int a;
    private final List b;
    private final int c;

    GeofencingRequest(int n2, List list, int n3) {
        this.a = n2;
        this.b = list;
        this.c = n3;
    }

    private GeofencingRequest(List list, int n2) {
        this(1, list, n2);
    }

    /* synthetic */ GeofencingRequest(List list, int n2, i i2) {
        this(list, n2);
    }

    public int a() {
        return this.a;
    }

    public List b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        r.a(this, parcel, n2);
    }
}

