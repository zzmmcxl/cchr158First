package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<PlayLoggerContext> {
    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        zzb.zzc(parcel, 3, playLoggerContext.zzbdL);
        zzb.zzc(parcel, 4, playLoggerContext.zzbdM);
        zzb.zza(parcel, 5, playLoggerContext.zzbdN, false);
        zzb.zza(parcel, 6, playLoggerContext.zzbdO, false);
        zzb.zza(parcel, 7, playLoggerContext.zzbdP);
        zzb.zza(parcel, 8, playLoggerContext.zzbdQ, false);
        zzb.zza(parcel, 9, playLoggerContext.zzbdR);
        zzb.zzc(parcel, 10, playLoggerContext.zzbdS);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjF(i);
    }

    public PlayLoggerContext zzgz(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case Barcode.WIFI /*9*/:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case Barcode.GEO /*10*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlayLoggerContext[] zzjF(int i) {
        return new PlayLoggerContext[i];
    }
}
