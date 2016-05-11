package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class HandleClientLifecycleEventRequest implements SafeParcelable {
    public static final Creator<HandleClientLifecycleEventRequest> CREATOR;
    public final int versionCode;
    public final ClientAppContext zzbcs;
    public final int zzbct;

    static {
        CREATOR = new zzc();
    }

    HandleClientLifecycleEventRequest(int versionCode, ClientAppContext clientAppContext, int clientLifecycleEvent) {
        this.versionCode = versionCode;
        this.zzbcs = clientAppContext;
        this.zzbct = clientLifecycleEvent;
    }

    public HandleClientLifecycleEventRequest(ClientAppContext clientAppContext, int clientLifecycleEvent) {
        this(1, clientAppContext, clientLifecycleEvent);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
