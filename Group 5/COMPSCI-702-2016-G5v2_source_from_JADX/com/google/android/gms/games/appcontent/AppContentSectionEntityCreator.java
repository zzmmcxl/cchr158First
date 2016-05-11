package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentSectionEntity.getVersionCode());
        zzb.zzc(parcel, 3, appContentSectionEntity.zzwk(), false);
        zzb.zza(parcel, 4, appContentSectionEntity.zzvQ(), false);
        zzb.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentSectionEntity.zzwc(), false);
        zzb.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzb.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzb.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzb.zza(parcel, 10, appContentSectionEntity.zzwl(), false);
        zzb.zzc(parcel, 14, appContentSectionEntity.zzwa(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzej(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgl(i);
    }

    public AppContentSectionEntity zzej(Parcel parcel) {
        ArrayList arrayList = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        String str6 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    arrayList3 = zza.zzc(parcel, zzat, AppContentActionEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    arrayList2 = zza.zzc(parcel, zzat, AppContentCardEntity.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.WIFI /*9*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.GEO /*10*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    arrayList = zza.zzc(parcel, zzat, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentSectionEntity(i, arrayList3, arrayList2, str6, bundle, str5, str4, str3, str2, str, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AppContentSectionEntity[] zzgl(int i) {
        return new AppContentSectionEntity[i];
    }
}
