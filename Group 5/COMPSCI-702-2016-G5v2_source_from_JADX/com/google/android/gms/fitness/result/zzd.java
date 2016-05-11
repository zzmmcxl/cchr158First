package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<DataSourceStatsResult> {
    static void zza(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataSourceStatsResult.zzavU, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataSourceStatsResult.mVersionCode);
        zzb.zza(parcel, 2, dataSourceStatsResult.zzUZ);
        zzb.zza(parcel, 3, dataSourceStatsResult.zzaBI);
        zzb.zza(parcel, 4, dataSourceStatsResult.zzaBJ);
        zzb.zza(parcel, 5, dataSourceStatsResult.zzaBK);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfR(i);
    }

    public DataSourceStatsResult zzdQ(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzau = zza.zzau(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    j = zza.zzi(parcel, zzat);
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
            return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSourceStatsResult[] zzfR(int i) {
        return new DataSourceStatsResult[i];
    }
}
