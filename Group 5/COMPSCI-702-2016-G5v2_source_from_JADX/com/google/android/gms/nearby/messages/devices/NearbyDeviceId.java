package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.CompletionEvent;

public class NearbyDeviceId implements SafeParcelable {
    public static final Creator<NearbyDeviceId> CREATOR;
    public static final NearbyDeviceId zzbcl;
    final int mVersionCode;
    private final int zzabB;
    final byte[] zzbbY;
    private final zzb zzbcm;
    private final zzd zzbcn;

    static {
        CREATOR = new zzh();
        zzbcl = new NearbyDeviceId();
    }

    private NearbyDeviceId() {
        this(1, 1, null);
    }

    NearbyDeviceId(int versionCode, int type, byte[] bytes) {
        zzd com_google_android_gms_nearby_messages_devices_zzd = null;
        this.mVersionCode = versionCode;
        this.zzabB = type;
        this.zzbbY = bytes;
        this.zzbcm = type == 2 ? new zzb(bytes) : null;
        if (type == 3) {
            com_google_android_gms_nearby_messages_devices_zzd = new zzd(bytes);
        }
        this.zzbcn = com_google_android_gms_nearby_messages_devices_zzd;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NearbyDeviceId)) {
            return false;
        }
        NearbyDeviceId nearbyDeviceId = (NearbyDeviceId) o;
        return zzw.equal(Integer.valueOf(this.zzabB), Integer.valueOf(nearbyDeviceId.zzabB)) && zzw.equal(this.zzbbY, nearbyDeviceId.zzbbY);
    }

    public int getType() {
        return this.zzabB;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzabB), this.zzbbY);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("NearbyDeviceId{");
        switch (this.zzabB) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                append.append("UNKNOWN");
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                append.append("eddystoneUid=").append(this.zzbcm);
                break;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                append.append("iBeaconId=").append(this.zzbcn);
                break;
        }
        append.append("}");
        return append.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }
}
