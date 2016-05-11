package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.location.places.internal.zzd;
import com.google.android.gms.location.places.internal.zze;
import com.google.android.gms.location.places.internal.zze.zza;
import com.google.android.gms.location.places.internal.zzj;
import com.google.android.gms.location.places.internal.zzk;

public class Places {
    public static final Api<PlacesOptions> GEO_DATA_API;
    public static final GeoDataApi GeoDataApi;
    public static final Api<PlacesOptions> PLACE_DETECTION_API;
    public static final PlaceDetectionApi PlaceDetectionApi;
    public static final zzc<zze> zzaPN;
    public static final zzc<zzk> zzaPO;

    static {
        zzaPN = new zzc();
        zzaPO = new zzc();
        GEO_DATA_API = new Api("Places.GEO_DATA_API", new zza(null), zzaPN);
        PLACE_DETECTION_API = new Api("Places.PLACE_DETECTION_API", new zzk.zza(null), zzaPO);
        GeoDataApi = new zzd();
        PlaceDetectionApi = new zzj();
    }

    private Places() {
    }
}
