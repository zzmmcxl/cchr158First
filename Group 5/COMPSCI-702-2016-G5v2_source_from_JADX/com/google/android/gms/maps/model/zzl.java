package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzl implements Creator<StreetViewPanoramaLocation> {
    static void zza(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        zzb.zza(parcel, 2, streetViewPanoramaLocation.links, i, false);
        zzb.zza(parcel, 3, streetViewPanoramaLocation.position, i, false);
        zzb.zza(parcel, 4, streetViewPanoramaLocation.panoId, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziu(i);
    }

    public StreetViewPanoramaLocation zzfG(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < zzau) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int zzg;
            String str2;
            int zzat = zza.zzat(parcel);
            String str3;
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = zza.zzg(parcel, zzat);
                    str2 = str3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) zza.zzb(parcel, zzat, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = i;
                    str3 = str;
                    latLng2 = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case Barcode.PHONE /*4*/:
                    str2 = zza.zzp(parcel, zzat);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = i;
                    break;
            }
            i = zzg;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == zzau) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StreetViewPanoramaLocation[] zziu(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
