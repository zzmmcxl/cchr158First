package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, filterHolder.zzauk, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, filterHolder.mVersionCode);
        zzb.zza(parcel, 2, filterHolder.zzaul, i, false);
        zzb.zza(parcel, 3, filterHolder.zzaum, i, false);
        zzb.zza(parcel, 4, filterHolder.zzaun, i, false);
        zzb.zza(parcel, 5, filterHolder.zzauo, i, false);
        zzb.zza(parcel, 6, filterHolder.zzaup, i, false);
        zzb.zza(parcel, 7, filterHolder.zzauq, i, false);
        zzb.zza(parcel, 8, filterHolder.zzaur, i, false);
        zzb.zza(parcel, 9, filterHolder.zzaus, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzco(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzej(i);
    }

    public FilterHolder zzco(Parcel parcel) {
        OwnedByMeFilter ownedByMeFilter = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        FullTextSearchFilter fullTextSearchFilter = null;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    comparisonFilter = (ComparisonFilter) zza.zza(parcel, zzat, ComparisonFilter.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    fieldOnlyFilter = (FieldOnlyFilter) zza.zza(parcel, zzat, FieldOnlyFilter.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    logicalFilter = (LogicalFilter) zza.zza(parcel, zzat, LogicalFilter.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    notFilter = (NotFilter) zza.zza(parcel, zzat, NotFilter.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    inFilter = (InFilter) zza.zza(parcel, zzat, InFilter.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    matchAllFilter = (MatchAllFilter) zza.zza(parcel, zzat, MatchAllFilter.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    hasFilter = (HasFilter) zza.zza(parcel, zzat, HasFilter.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    fullTextSearchFilter = (FullTextSearchFilter) zza.zza(parcel, zzat, FullTextSearchFilter.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    ownedByMeFilter = (OwnedByMeFilter) zza.zza(parcel, zzat, OwnedByMeFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FilterHolder[] zzej(int i) {
        return new FilterHolder[i];
    }
}
