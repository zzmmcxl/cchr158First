package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DeleteRequest implements SafeParcelable {
    public static final Creator<DeleteRequest> CREATOR;
    final int mVersionCode;
    private final Credential zzWu;

    static {
        CREATOR = new zzg();
    }

    DeleteRequest(int version, Credential credential) {
        this.mVersionCode = version;
        this.zzWu = credential;
    }

    public DeleteRequest(Credential credential) {
        this(1, credential);
    }

    public int describeContents() {
        return 0;
    }

    public Credential getCredential() {
        return this.zzWu;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
