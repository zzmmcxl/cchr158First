package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzb implements Creator<SortOrder> {
    static void zza(SortOrder sortOrder, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sortOrder.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sortOrder.zzaud, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sortOrder.zzaue);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzck(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzef(i);
    }

    public SortOrder zzck(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzat, FieldWithSortOrder.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzat);
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
            return new SortOrder(i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SortOrder[] zzef(int i) {
        return new SortOrder[i];
    }
}
