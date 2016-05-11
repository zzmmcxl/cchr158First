package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzd implements Creator<LaunchOptions> {
    static void zza(LaunchOptions launchOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, launchOptions.getVersionCode());
        zzb.zza(parcel, 2, launchOptions.getRelaunchIfRunning());
        zzb.zza(parcel, 3, launchOptions.getLanguage(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzac(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaZ(i);
    }

    public LaunchOptions[] zzaZ(int i) {
        return new LaunchOptions[i];
    }

    public LaunchOptions zzac(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LaunchOptions(i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
