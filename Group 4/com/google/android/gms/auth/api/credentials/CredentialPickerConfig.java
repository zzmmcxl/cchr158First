/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.a;
import com.google.android.gms.auth.api.credentials.b;
import com.google.android.gms.auth.api.credentials.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new g();
    final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    CredentialPickerConfig(int n2, boolean bl2, boolean bl3, boolean bl4) {
        this.a = n2;
        this.b = bl2;
        this.c = bl3;
        this.d = bl4;
    }

    private CredentialPickerConfig(b b2) {
        this(1, b.a(b2), b.b(b2), b.c(b2));
    }

    /* synthetic */ CredentialPickerConfig(b b2, a a2) {
        this(b2);
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        g.a(this, parcel, n2);
    }
}

