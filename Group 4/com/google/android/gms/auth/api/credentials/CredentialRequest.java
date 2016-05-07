/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.b;
import com.google.android.gms.auth.api.credentials.h;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new h();
    final int a;
    private final boolean b;
    private final String[] c;
    private final CredentialPickerConfig d;
    private final CredentialPickerConfig e;

    CredentialRequest(int n2, boolean bl2, String[] arrstring, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.a = n2;
        this.b = bl2;
        this.c = (String[])bf.a(arrstring);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new b().a();
        }
        this.d = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new b().a();
        }
        this.e = credentialPickerConfig2;
    }

    public boolean a() {
        return this.b;
    }

    public String[] b() {
        return this.c;
    }

    public CredentialPickerConfig c() {
        return this.d;
    }

    public CredentialPickerConfig d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        h.a(this, parcel, n2);
    }
}

