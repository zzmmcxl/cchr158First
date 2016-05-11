package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverInfoEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverPhotoEntity;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashSet;
import java.util.Set;

public class zzc implements Creator<CoverEntity> {
    static void zza(CoverEntity coverEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = coverEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, coverEntity.zzbgg, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, coverEntity.zzbgh, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zzc(parcel, 4, coverEntity.zzbgi);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjN(i);
    }

    public CoverEntity zzgG(Parcel parcel) {
        CoverPhotoEntity coverPhotoEntity = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        CoverInfoEntity coverInfoEntity = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    CoverInfoEntity coverInfoEntity2 = (CoverInfoEntity) zza.zza(parcel, zzat, CoverInfoEntity.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    coverInfoEntity = coverInfoEntity2;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    CoverPhotoEntity coverPhotoEntity2 = (CoverPhotoEntity) zza.zza(parcel, zzat, CoverPhotoEntity.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    coverPhotoEntity = coverPhotoEntity2;
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CoverEntity(hashSet, i2, coverInfoEntity, coverPhotoEntity, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CoverEntity[] zzjN(int i) {
        return new CoverEntity[i];
    }
}
