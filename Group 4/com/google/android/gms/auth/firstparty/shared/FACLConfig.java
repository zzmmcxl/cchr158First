/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.a;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLConfig
implements SafeParcelable {
    public static final a CREATOR = new a();
    final int a;
    boolean b;
    String c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    FACLConfig(int n2, boolean bl2, String string, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.a = n2;
        this.b = bl2;
        this.c = string;
        this.d = bl3;
        this.e = bl4;
        this.f = bl5;
        this.g = bl6;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof FACLConfig;
        boolean bl3 = false;
        if (!bl2) return bl3;
        FACLConfig fACLConfig = (FACLConfig)object;
        boolean bl4 = this.b;
        boolean bl5 = fACLConfig.b;
        bl3 = false;
        if (bl4 != bl5) return bl3;
        boolean bl6 = TextUtils.equals((CharSequence)this.c, (CharSequence)fACLConfig.c);
        bl3 = false;
        if (!bl6) return bl3;
        boolean bl7 = this.d;
        boolean bl8 = fACLConfig.d;
        bl3 = false;
        if (bl7 != bl8) return bl3;
        boolean bl9 = this.e;
        boolean bl10 = fACLConfig.e;
        bl3 = false;
        if (bl9 != bl10) return bl3;
        boolean bl11 = this.f;
        boolean bl12 = fACLConfig.f;
        bl3 = false;
        if (bl11 != bl12) return bl3;
        boolean bl13 = this.g;
        boolean bl14 = fACLConfig.g;
        bl3 = false;
        if (bl13 != bl14) return bl3;
        return true;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.c, this.d, this.e, this.f, this.g};
        return bc.a(arrobject);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

