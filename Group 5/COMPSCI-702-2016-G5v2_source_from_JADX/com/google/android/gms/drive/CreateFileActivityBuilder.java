package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzl;
import com.google.android.gms.drive.internal.zzv;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzl zzaoB;
    private DriveContents zzaoC;
    private boolean zzaoD;

    public CreateFileActivityBuilder() {
        this.zzaoB = new zzl(0);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(Boolean.valueOf(this.zzaoD), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzaoC != null) {
            this.zzaoC.zzsy();
        }
        return this.zzaoB.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzaoB.zza(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.zzaoB.zzdb(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.zzaoB.zzcZ(1);
        } else if (!(driveContents instanceof zzv)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzsz()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.zzaoB.zzcZ(driveContents.zzsx().getRequestId());
            this.zzaoC = driveContents;
        }
        this.zzaoD = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.zzaoB.zza(metadataChangeSet);
        return this;
    }
}
