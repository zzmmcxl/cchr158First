/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.ac;

public final class LocationSettingsStates
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new ac();
    private final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;

    LocationSettingsStates(int n2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.a = n2;
        this.b = bl2;
        this.c = bl3;
        this.d = bl4;
        this.e = bl5;
        this.f = bl6;
        this.g = bl7;
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.g;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ac.a(this, parcel, n2);
    }
}

