/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.n;

public class SignInResponse
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new n();
    final int a;
    private final ConnectionResult b;
    private final ResolveAccountResponse c;

    public SignInResponse(int n2) {
        this(new ConnectionResult(n2, null), null);
    }

    SignInResponse(int n2, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.a = n2;
        this.b = connectionResult;
        this.c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public ConnectionResult a() {
        return this.b;
    }

    public ResolveAccountResponse b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        n.a(this, parcel, n2);
    }
}

