/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyResponse
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new d();
    final int a;
    public final int b;
    public final PendingIntent c;
    public final int d;
    final Bundle e;
    public final byte[] f;

    ProxyResponse(int n2, int n3, PendingIntent pendingIntent, int n4, Bundle bundle, byte[] arrby) {
        this.a = n2;
        this.b = n3;
        this.d = n4;
        this.e = bundle;
        this.f = arrby;
        this.c = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        d.a(this, parcel, n2);
    }
}

