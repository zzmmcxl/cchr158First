/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData
implements SafeParcelable {
    public static final b CREATOR = new b();
    final int a;
    FACLConfig b;
    String c;
    boolean d;
    String e;

    FACLData(int n2, FACLConfig fACLConfig, String string, boolean bl2, String string2) {
        this.a = n2;
        this.b = fACLConfig;
        this.c = string;
        this.d = bl2;
        this.e = string2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

