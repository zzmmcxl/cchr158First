package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzap.zza;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zznm;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR;
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int mVersionCode;
    final int zzBc;
    final String zzVa;
    final DriveId zzaoz;
    final ParcelFileDescriptor zzapD;
    final ParcelFileDescriptor zzapE;
    final MetadataBundle zzapF;
    final List<String> zzapG;
    final IBinder zzapH;
    private boolean zzapI;
    private boolean zzapJ;
    private boolean zzapK;

    static {
        CREATOR = new zze();
    }

    CompletionEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, List<String> trackingTags, int status, IBinder releaseCallback) {
        this.zzapI = false;
        this.zzapJ = false;
        this.zzapK = false;
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzVa = accountName;
        this.zzapD = baseParcelFileDescriptor;
        this.zzapE = modifiedParcelFileDescriptor;
        this.zzapF = modifiedMetadataBundle;
        this.zzapG = trackingTags;
        this.zzBc = status;
        this.zzapH = releaseCallback;
    }

    private void zzsU() {
        if (this.zzapK) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    private void zzv(boolean z) {
        zzsU();
        this.zzapK = true;
        zzna.zza(this.zzapD);
        zzna.zza(this.zzapE);
        if (this.zzapF != null && this.zzapF.zzc(zznm.zzatz)) {
            ((BitmapTeleporter) this.zzapF.zza(zznm.zzatz)).release();
        }
        if (this.zzapH == null) {
            zzz.zzA("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            zza.zzbd(this.zzapH).zzv(z);
        } catch (RemoteException e) {
            zzz.zzA("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzv(false);
    }

    public String getAccountName() {
        zzsU();
        return this.zzVa;
    }

    public InputStream getBaseContentsInputStream() {
        zzsU();
        if (this.zzapD == null) {
            return null;
        }
        if (this.zzapI) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzapI = true;
        return new FileInputStream(this.zzapD.getFileDescriptor());
    }

    public DriveId getDriveId() {
        zzsU();
        return this.zzaoz;
    }

    public InputStream getModifiedContentsInputStream() {
        zzsU();
        if (this.zzapE == null) {
            return null;
        }
        if (this.zzapJ) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzapJ = true;
        return new FileInputStream(this.zzapE.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzsU();
        return this.zzapF != null ? new MetadataChangeSet(this.zzapF) : null;
    }

    public int getStatus() {
        zzsU();
        return this.zzBc;
    }

    public List<String> getTrackingTags() {
        zzsU();
        return new ArrayList(this.zzapG);
    }

    public int getType() {
        return STATUS_CONFLICT;
    }

    public void snooze() {
        zzv(true);
    }

    public String toString() {
        String str = this.zzapG == null ? "<null>" : "'" + TextUtils.join("','", this.zzapG) + "'";
        Object[] objArr = new Object[STATUS_CANCELED];
        objArr[0] = this.zzaoz;
        objArr[STATUS_FAILURE] = Integer.valueOf(this.zzBc);
        objArr[STATUS_CONFLICT] = str;
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", objArr);
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags | STATUS_FAILURE);
    }
}
