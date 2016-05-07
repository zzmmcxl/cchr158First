/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.au;

public final class EventParcel
implements SafeParcelable {
    public static final au CREATOR = new au();
    public final int a;
    public final String b;
    public final EventParams c;
    public final String d;
    public final long e;

    EventParcel(int n2, String string, EventParams eventParams, String string2, long l2) {
        this.a = n2;
        this.b = string;
        this.c = eventParams;
        this.d = string2;
        this.e = l2;
    }

    public EventParcel(String string, EventParams eventParams, String string2, long l2) {
        this.a = 1;
        this.b = string;
        this.c = eventParams;
        this.d = string2;
        this.e = l2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "origin=" + this.d + ",name=" + this.b + ",params=" + this.c;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        au.a(this, parcel, n2);
    }
}

