package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR;
    final int mVersionCode;
    public Uri uri;
    private byte[] zzaKm;
    private String zzbqU;
    public ParcelFileDescriptor zzbqV;

    static {
        CREATOR = new zze();
    }

    Asset(int versionCode, byte[] data, String digest, ParcelFileDescriptor fd, Uri uri) {
        this.mVersionCode = versionCode;
        this.zzaKm = data;
        this.zzbqU = digest;
        this.zzbqV = fd;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] assetData) {
        if (assetData != null) {
            return new Asset(1, assetData, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor fd) {
        if (fd != null) {
            return new Asset(1, null, null, fd, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String digest) {
        if (digest != null) {
            return new Asset(1, null, digest, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(1, null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) o;
        return zzw.equal(this.zzaKm, asset.zzaKm) && zzw.equal(this.zzbqU, asset.zzbqU) && zzw.equal(this.zzbqV, asset.zzbqV) && zzw.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public String getDigest() {
        return this.zzbqU;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzbqV;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaKm, this.zzbqU, this.zzbqV, this.uri);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzbqU == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.zzbqU);
        }
        if (this.zzaKm != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.zzaKm.length);
        }
        if (this.zzbqV != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.zzbqV);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags | 1);
    }
}
