/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.aq;
import com.google.android.gms.common.internal.bh;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new bh();
    final int a;
    IBinder b;
    private ConnectionResult c;
    private boolean d;
    private boolean e;

    ResolveAccountResponse(int n2, IBinder iBinder, ConnectionResult connectionResult, boolean bl2, boolean bl3) {
        this.a = n2;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = bl2;
        this.e = bl3;
    }

    public ap a() {
        return aq.a(this.b);
    }

    public ConnectionResult b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse)object;
        if (!this.c.equals(resolveAccountResponse.c)) return false;
        if (this.a().equals(resolveAccountResponse.a())) return true;
        return false;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        bh.a(this, parcel, n2);
    }
}

