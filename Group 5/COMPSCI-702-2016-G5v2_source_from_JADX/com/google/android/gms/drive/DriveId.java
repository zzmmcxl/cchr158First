package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.woop.tryreverseengineerthis.BuildConfig;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR;
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final String zzaoL;
    final long zzaoM;
    final int zzaoN;
    private volatile String zzaoO;
    final long zzaou;
    private volatile String zzaow;

    static {
        CREATOR = new zze();
    }

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        boolean z = false;
        this.zzaow = null;
        this.zzaoO = null;
        this.mVersionCode = versionCode;
        this.zzaoL = resourceId;
        zzx.zzac(!BuildConfig.FLAVOR.equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        zzx.zzac(z);
        this.zzaoM = sqlId;
        this.zzaou = databaseInstanceId;
        this.zzaoN = resourceType;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        this(RESOURCE_TYPE_FOLDER, resourceId, sqlId, databaseInstanceId, resourceType);
    }

    public static DriveId decodeFromString(String s) {
        zzx.zzb(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return zzl(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcW(String str) {
        zzx.zzz(str);
        return new DriveId(str, -1, -1, RESOURCE_TYPE_UNKNOWN);
    }

    static DriveId zzl(byte[] bArr) {
        try {
            zzat zzm = zzat.zzm(bArr);
            return new DriveId(zzm.versionCode, BuildConfig.FLAVOR.equals(zzm.zzarY) ? null : zzm.zzarY, zzm.zzarZ, zzm.zzarW, zzm.zzasa);
        } catch (zzst e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzsA() {
        zzsu com_google_android_gms_drive_internal_zzau = new zzau();
        com_google_android_gms_drive_internal_zzau.zzarZ = this.zzaoM;
        com_google_android_gms_drive_internal_zzau.zzarW = this.zzaou;
        return zzsu.toByteArray(com_google_android_gms_drive_internal_zzau);
    }

    public DriveFile asDriveFile() {
        if (this.zzaoN != RESOURCE_TYPE_FOLDER) {
            return new zzw(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.zzaoN != 0) {
            return new zzy(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        return this.zzaoN == RESOURCE_TYPE_FOLDER ? asDriveFolder() : this.zzaoN == 0 ? asDriveFile() : new zzab(this);
    }

    public int describeContents() {
        return RESOURCE_TYPE_FILE;
    }

    public final String encodeToString() {
        if (this.zzaow == null) {
            this.zzaow = "DriveId:" + Base64.encodeToString(zzsu(), 10);
        }
        return this.zzaow;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzaou != this.zzaou) {
            return false;
        }
        if (driveId.zzaoM == -1 && this.zzaoM == -1) {
            return driveId.zzaoL.equals(this.zzaoL);
        }
        if (this.zzaoL == null || driveId.zzaoL == null) {
            if (driveId.zzaoM != this.zzaoM) {
                z = false;
            }
            return z;
        } else if (driveId.zzaoM != this.zzaoM) {
            return false;
        } else {
            if (driveId.zzaoL.equals(this.zzaoL)) {
                return true;
            }
            zzz.zzz("DriveId", "Unexpected unequal resourceId for same DriveId object.");
            return false;
        }
    }

    public String getResourceId() {
        return this.zzaoL;
    }

    public int getResourceType() {
        return this.zzaoN;
    }

    public int hashCode() {
        return this.zzaoM == -1 ? this.zzaoL.hashCode() : (String.valueOf(this.zzaou) + String.valueOf(this.zzaoM)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzaoO == null) {
            this.zzaoO = Base64.encodeToString(zzsA(), 10);
        }
        return this.zzaoO;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }

    final byte[] zzsu() {
        zzsu com_google_android_gms_drive_internal_zzat = new zzat();
        com_google_android_gms_drive_internal_zzat.versionCode = this.mVersionCode;
        com_google_android_gms_drive_internal_zzat.zzarY = this.zzaoL == null ? BuildConfig.FLAVOR : this.zzaoL;
        com_google_android_gms_drive_internal_zzat.zzarZ = this.zzaoM;
        com_google_android_gms_drive_internal_zzat.zzarW = this.zzaou;
        com_google_android_gms_drive_internal_zzat.zzasa = this.zzaoN;
        return zzsu.toByteArray(com_google_android_gms_drive_internal_zzat);
    }
}
