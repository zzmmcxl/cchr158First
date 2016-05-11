package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzj implements Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, usageInfo.zzUs, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, usageInfo.mVersionCode);
        zzb.zza(parcel, 2, usageInfo.zzUt);
        zzb.zzc(parcel, 3, usageInfo.zzUu);
        zzb.zza(parcel, 4, usageInfo.zzvp, false);
        zzb.zza(parcel, 5, usageInfo.zzUv, i, false);
        zzb.zza(parcel, 6, usageInfo.zzUw);
        zzb.zzc(parcel, 7, usageInfo.zzUx);
        zzb.zzc(parcel, 8, usageInfo.zzUy);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzat(i);
    }

    public UsageInfo[] zzat(int i) {
        return new UsageInfo[i];
    }

    public UsageInfo zzy(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    documentId = (DocumentId) zza.zza(parcel, zzat, DocumentId.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    documentContents = (DocumentContents) zza.zza(parcel, zzat, DocumentContents.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
