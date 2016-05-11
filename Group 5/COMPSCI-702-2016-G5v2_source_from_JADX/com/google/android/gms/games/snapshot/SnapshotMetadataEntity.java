package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzms;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final Creator<SnapshotMetadataEntity> CREATOR;
    private final int mVersionCode;
    private final String zzaEp;
    private final GameEntity zzaJE;
    private final Uri zzaKQ;
    private final PlayerEntity zzaKT;
    private final String zzaKU;
    private final long zzaKV;
    private final long zzaKW;
    private final float zzaKX;
    private final String zzaKY;
    private final boolean zzaKZ;
    private final long zzaLa;
    private final String zzaLb;
    private final String zzapg;
    private final String zzaxl;

    static {
        CREATOR = new SnapshotMetadataEntityCreator();
    }

    SnapshotMetadataEntity(int versionCode, GameEntity game, PlayerEntity owner, String snapshotId, Uri coverImageUri, String coverImageUrl, String title, String description, long lastModifiedTimestamp, long playedTime, float coverImageAspectRatio, String uniqueName, boolean changePending, long progressValue, String deviceName) {
        this.mVersionCode = versionCode;
        this.zzaJE = game;
        this.zzaKT = owner;
        this.zzaEp = snapshotId;
        this.zzaKQ = coverImageUri;
        this.zzaKU = coverImageUrl;
        this.zzaKX = coverImageAspectRatio;
        this.zzapg = title;
        this.zzaxl = description;
        this.zzaKV = lastModifiedTimestamp;
        this.zzaKW = playedTime;
        this.zzaKY = uniqueName;
        this.zzaKZ = changePending;
        this.zzaLa = progressValue;
        this.zzaLb = deviceName;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.mVersionCode = 6;
        this.zzaJE = new GameEntity(snapshotMetadata.getGame());
        this.zzaKT = new PlayerEntity(snapshotMetadata.getOwner());
        this.zzaEp = snapshotMetadata.getSnapshotId();
        this.zzaKQ = snapshotMetadata.getCoverImageUri();
        this.zzaKU = snapshotMetadata.getCoverImageUrl();
        this.zzaKX = snapshotMetadata.getCoverImageAspectRatio();
        this.zzapg = snapshotMetadata.getTitle();
        this.zzaxl = snapshotMetadata.getDescription();
        this.zzaKV = snapshotMetadata.getLastModifiedTimestamp();
        this.zzaKW = snapshotMetadata.getPlayedTime();
        this.zzaKY = snapshotMetadata.getUniqueName();
        this.zzaKZ = snapshotMetadata.hasChangePending();
        this.zzaLa = snapshotMetadata.getProgressValue();
        this.zzaLb = snapshotMetadata.getDeviceName();
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return zzw.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzw.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzw.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzw.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzw.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzw.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzw.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && zzw.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzw.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzw.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzw.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzw.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzw.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && zzw.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return zzw.zzy(snapshotMetadata).zzg("Game", snapshotMetadata.getGame()).zzg("Owner", snapshotMetadata.getOwner()).zzg("SnapshotId", snapshotMetadata.getSnapshotId()).zzg("CoverImageUri", snapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).zzg("Description", snapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).zzg("UniqueName", snapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).zzg("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzaKX;
    }

    public Uri getCoverImageUri() {
        return this.zzaKQ;
    }

    public String getCoverImageUrl() {
        return this.zzaKU;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaxl, dataOut);
    }

    public String getDeviceName() {
        return this.zzaLb;
    }

    public Game getGame() {
        return this.zzaJE;
    }

    public long getLastModifiedTimestamp() {
        return this.zzaKV;
    }

    public Player getOwner() {
        return this.zzaKT;
    }

    public long getPlayedTime() {
        return this.zzaKW;
    }

    public long getProgressValue() {
        return this.zzaLa;
    }

    public String getSnapshotId() {
        return this.zzaEp;
    }

    public String getTitle() {
        return this.zzapg;
    }

    public String getUniqueName() {
        return this.zzaKY;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasChangePending() {
        return this.zzaKZ;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataEntityCreator.zza(this, out, flags);
    }
}
