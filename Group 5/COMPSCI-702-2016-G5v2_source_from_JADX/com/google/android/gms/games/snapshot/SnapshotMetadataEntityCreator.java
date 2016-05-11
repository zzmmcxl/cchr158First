package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    static void zza(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, snapshotMetadataEntity.getGame(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotMetadataEntity.getVersionCode());
        zzb.zza(parcel, 2, snapshotMetadataEntity.getOwner(), i, false);
        zzb.zza(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        zzb.zza(parcel, 5, snapshotMetadataEntity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        zzb.zza(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        zzb.zza(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        zzb.zza(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        zzb.zza(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        zzb.zza(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        zzb.zza(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        zzb.zza(parcel, 13, snapshotMetadataEntity.hasChangePending());
        zzb.zza(parcel, 14, snapshotMetadataEntity.getProgressValue());
        zzb.zza(parcel, 15, snapshotMetadataEntity.getDeviceName(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgU(i);
    }

    public SnapshotMetadataEntity zzeD(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z = false;
        long j3 = 0;
        String str6 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    gameEntity = (GameEntity) zza.zza(parcel, zzat, GameEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzat, PlayerEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.WIFI /*9*/:
                    j = zza.zzi(parcel, zzat);
                    break;
                case Barcode.GEO /*10*/:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    f = zza.zzl(parcel, zzat);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5, z, j3, str6);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SnapshotMetadataEntity[] zzgU(int i) {
        return new SnapshotMetadataEntity[i];
    }
}
