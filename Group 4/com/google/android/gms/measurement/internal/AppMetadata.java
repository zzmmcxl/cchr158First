/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.ah;

public class AppMetadata
implements SafeParcelable {
    public static final ah CREATOR = new ah();
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    public final String h;
    public final boolean i;
    public final boolean j;

    AppMetadata(int n2, String string, String string2, String string3, String string4, long l2, long l3, String string5, boolean bl2, boolean bl3) {
        this.a = n2;
        this.b = string;
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = l2;
        this.g = l3;
        this.h = string5;
        this.i = n2 >= 3 ? bl2 : true;
        this.j = bl3;
    }

    AppMetadata(String string, String string2, String string3, String string4, long l2, long l3, String string5, boolean bl2, boolean bl3) {
        bf.a(string);
        this.a = 4;
        this.b = string;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = null;
        }
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = l2;
        this.g = l3;
        this.h = string5;
        this.i = bl2;
        this.j = bl3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ah.a(this, parcel, n2);
    }
}

