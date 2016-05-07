/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.i;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new i();
    final int a;
    private final String b;
    private final String c;

    IdToken(int n2, String string, String string2) {
        this.a = n2;
        this.b = string;
        this.c = string2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        i.a(this, parcel, n2);
    }
}

