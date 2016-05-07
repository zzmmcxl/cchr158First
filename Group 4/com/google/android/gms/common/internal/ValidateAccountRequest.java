/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new c();
    final int a;
    final IBinder b;
    private final int c;
    private final Scope[] d;
    private final Bundle e;
    private final String f;

    ValidateAccountRequest(int n2, int n3, IBinder iBinder, Scope[] arrscope, Bundle bundle, String string) {
        this.a = n2;
        this.c = n3;
        this.b = iBinder;
        this.d = arrscope;
        this.e = bundle;
        this.f = string;
    }

    public int a() {
        return this.c;
    }

    public Scope[] b() {
        return this.d;
    }

    public String c() {
        return this.f;
    }

    public Bundle d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

