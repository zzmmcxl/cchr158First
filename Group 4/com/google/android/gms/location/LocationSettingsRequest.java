/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.aa;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new aa();
    private final int a;
    private final List b;
    private final boolean c;
    private final boolean d;

    LocationSettingsRequest(int n2, List list, boolean bl2, boolean bl3) {
        this.a = n2;
        this.b = list;
        this.c = bl2;
        this.d = bl3;
    }

    public int a() {
        return this.a;
    }

    public List b() {
        return Collections.unmodifiableList(this.b);
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        aa.a(this, parcel, n2);
    }
}

