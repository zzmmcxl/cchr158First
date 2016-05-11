package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
    static void zza(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appContentActionEntity.zzvP(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentActionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentActionEntity.zzvQ(), false);
        zzb.zza(parcel, 3, appContentActionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentActionEntity.getType(), false);
        zzb.zza(parcel, 7, appContentActionEntity.getId(), false);
        zzb.zza(parcel, 8, appContentActionEntity.zzvO(), i, false);
        zzb.zza(parcel, 9, appContentActionEntity.zzvR(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzef(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgh(i);
    }

    public AppContentActionEntity zzef(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    arrayList = zza.zzc(parcel, zzat, AppContentConditionEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) zza.zza(parcel, zzat, AppContentAnnotationEntity.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    str = zza.zzp(parcel, zzat);
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
            return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, appContentAnnotationEntity, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AppContentActionEntity[] zzgh(int i) {
        return new AppContentActionEntity[i];
    }
}
