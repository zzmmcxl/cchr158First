package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznr;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzawc;
    private final List<String> zzawd;
    private final List<DataType> zzawe;

    static {
        CREATOR = new zzb();
    }

    BleDevice(int versionCode, String address, String name, List<String> profiles, List<DataType> dataTypes) {
        this.mVersionCode = versionCode;
        this.zzawc = address;
        this.mName = name;
        this.zzawd = Collections.unmodifiableList(profiles);
        this.zzawe = Collections.unmodifiableList(dataTypes);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzawc.equals(bleDevice.zzawc) && zznr.zza(bleDevice.zzawd, this.zzawd) && zznr.zza(this.zzawe, bleDevice.zzawe);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof BleDevice) && zza((BleDevice) o));
    }

    public String getAddress() {
        return this.zzawc;
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.zzawd;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzawc, this.zzawd, this.zzawe);
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.mName).zzg("address", this.zzawc).zzg("dataTypes", this.zzawe).zzg("supportedProfiles", this.zzawd).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
