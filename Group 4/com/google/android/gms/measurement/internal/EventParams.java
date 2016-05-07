/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.a;
import com.google.android.gms.measurement.internal.at;
import java.util.Iterator;

public class EventParams
implements SafeParcelable,
Iterable {
    public static final at CREATOR = new at();
    public final int a;
    private final Bundle b;

    EventParams(int n2, Bundle bundle) {
        this.a = n2;
        this.b = bundle;
    }

    EventParams(Bundle bundle) {
        bf.a((Object)bundle);
        this.b = bundle;
        this.a = 1;
    }

    static /* synthetic */ Bundle a(EventParams eventParams) {
        return eventParams.b;
    }

    public int a() {
        return this.b.size();
    }

    Object a(String string) {
        return this.b.get(string);
    }

    public Bundle b() {
        return new Bundle(this.b);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator iterator() {
        return new a(this);
    }

    public String toString() {
        return this.b.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        at.a(this, parcel, n2);
    }
}

