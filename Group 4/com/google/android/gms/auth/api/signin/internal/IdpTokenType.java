/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.t;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdpTokenType
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final IdpTokenType a;
    public static final IdpTokenType b;
    final int c;
    private final String d;

    static {
        a = new IdpTokenType("accessToken");
        b = new IdpTokenType("idToken");
        CREATOR = new t();
    }

    IdpTokenType(int n2, String string) {
        this.c = n2;
        this.d = bf.a(string);
    }

    private IdpTokenType(String string) {
        this(1, string);
    }

    public String a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = false;
        if (object == null) return bl2;
        try {
            boolean bl3 = this.d.equals(((IdpTokenType)object).a());
            bl2 = false;
            if (!bl3) return bl2;
            return true;
        }
        catch (ClassCastException var3_4) {
            return false;
        }
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        t.a(this, parcel, n2);
    }
}

