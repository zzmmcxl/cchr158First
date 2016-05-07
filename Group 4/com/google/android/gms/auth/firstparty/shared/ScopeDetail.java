/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.FACLData;
import com.google.android.gms.auth.firstparty.shared.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail
implements SafeParcelable {
    public static final c CREATOR = new c();
    final int a;
    String b;
    String c;
    String d;
    String e;
    String f;
    List g;
    public FACLData h;

    ScopeDetail(int n2, String string, String string2, String string3, String string4, String string5, List list, FACLData fACLData) {
        this.a = n2;
        this.b = string;
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = string5;
        this.g = list;
        this.h = fACLData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

