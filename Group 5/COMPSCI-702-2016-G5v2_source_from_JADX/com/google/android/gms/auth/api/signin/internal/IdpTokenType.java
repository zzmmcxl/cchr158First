package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class IdpTokenType implements SafeParcelable {
    public static final Creator<IdpTokenType> CREATOR;
    public static final IdpTokenType zzXA;
    public static final IdpTokenType zzXB;
    final int versionCode;
    private final String zzXC;

    static {
        zzXA = new IdpTokenType("accessToken");
        zzXB = new IdpTokenType("idToken");
        CREATOR = new zzj();
    }

    IdpTokenType(int versionCode, String tokenType) {
        this.versionCode = versionCode;
        this.zzXC = zzx.zzcM(tokenType);
    }

    private IdpTokenType(String tokenType) {
        this(1, tokenType);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.zzXC.equals(((IdpTokenType) obj).zzng());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return this.zzXC.hashCode();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    public String zzng() {
        return this.zzXC;
    }
}
