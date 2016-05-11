package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    static void zza(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerLevelInfo.getVersionCode());
        zzb.zza(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        zzb.zza(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        zzb.zza(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzed(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgf(i);
    }

    public PlayerLevelInfo zzed(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    playerLevel2 = (PlayerLevel) zza.zza(parcel, zzat, PlayerLevel.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    playerLevel = (PlayerLevel) zza.zza(parcel, zzat, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlayerLevelInfo[] zzgf(int i) {
        return new PlayerLevelInfo[i];
    }
}
