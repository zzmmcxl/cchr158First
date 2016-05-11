package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode.CalendarDateTime;

public class zzc implements Creator<CalendarDateTime> {
    static void zza(CalendarDateTime calendarDateTime, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, calendarDateTime.versionCode);
        zzb.zzc(parcel, 2, calendarDateTime.year);
        zzb.zzc(parcel, 3, calendarDateTime.month);
        zzb.zzc(parcel, 4, calendarDateTime.day);
        zzb.zzc(parcel, 5, calendarDateTime.hours);
        zzb.zzc(parcel, 6, calendarDateTime.minutes);
        zzb.zzc(parcel, 7, calendarDateTime.seconds);
        zzb.zza(parcel, 8, calendarDateTime.isUtc);
        zzb.zza(parcel, 9, calendarDateTime.rawValue, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkv(i);
    }

    public CalendarDateTime zzgY(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i7 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i6 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.WIFI /*9*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CalendarDateTime(i7, i6, i5, i4, i3, i2, i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CalendarDateTime[] zzkv(int i) {
        return new CalendarDateTime[i];
    }
}
