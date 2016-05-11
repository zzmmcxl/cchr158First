package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.woop.tryreverseengineerthis.BuildConfig;
import java.util.Arrays;

public class NearbyDevice implements SafeParcelable {
    public static final Creator<NearbyDevice> CREATOR;
    private static final NearbyDeviceId[] zzbcb;
    private static final String[] zzbcc;
    public static final NearbyDevice zzbcd;
    final int mVersionCode;
    @Nullable
    @Deprecated
    private final String zzF;
    @Deprecated
    private final NearbyDeviceId zzbce;
    private final String zzbcf;
    private final NearbyDeviceId[] zzbcg;
    private final String[] zzbch;

    static {
        CREATOR = new zzf();
        zzbcb = new NearbyDeviceId[0];
        zzbcc = new String[0];
        zzbcd = new NearbyDevice(BuildConfig.FLAVOR, zzbcb, zzbcc);
    }

    NearbyDevice(int versionCode, @Nullable NearbyDeviceId unused, @Nullable String unused2, @Nullable String handle, @Nullable NearbyDeviceId[] ids, @Nullable String[] urls) {
        this.mVersionCode = ((Integer) zzx.zzz(Integer.valueOf(versionCode))).intValue();
        if (handle == null) {
            handle = BuildConfig.FLAVOR;
        }
        this.zzbcf = handle;
        if (ids == null) {
            ids = zzbcb;
        }
        this.zzbcg = ids;
        if (urls == null) {
            urls = zzbcc;
        }
        this.zzbch = urls;
        this.zzbce = this.zzbcg.length == 0 ? NearbyDeviceId.zzbcl : this.zzbcg[0];
        this.zzF = this.zzbch.length == 0 ? null : this.zzbch[0];
    }

    public NearbyDevice(String handle, NearbyDeviceId[] ids, String[] urls) {
        this(1, null, null, handle, ids, urls);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NearbyDevice)) {
            return false;
        }
        return zzw.equal(this.zzbcf, ((NearbyDevice) o).zzbcf);
    }

    @Nullable
    @Deprecated
    public String getUrl() {
        return this.zzbch.length == 0 ? null : this.zzbch[0];
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbcf);
    }

    public String toString() {
        return "NearbyDevice{deviceHandle=" + this.zzbcf + ", ids=" + Arrays.toString(this.zzbcg) + ", urls=" + Arrays.toString(this.zzbch) + "}";
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public NearbyDeviceId[] zzEA() {
        return this.zzbcg;
    }

    public String[] zzEB() {
        return this.zzbch;
    }

    public String zzEC() {
        return this.zzbcf;
    }

    @Deprecated
    public NearbyDeviceId zzEz() {
        return this.zzbcg.length == 0 ? NearbyDeviceId.zzbcl : this.zzbcg[0];
    }
}
