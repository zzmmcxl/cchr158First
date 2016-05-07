/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.ac;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new ac();
    final int a;
    private final String b;

    Scope(int n2, String string) {
        bf.a(string, (Object)"scopeUri must not be null or empty");
        this.a = n2;
        this.b = string;
    }

    public Scope(String string) {
        this(1, string);
    }

    public String a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Scope) return this.b.equals(((Scope)object).b);
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ac.a(this, parcel, n2);
    }
}

