package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.zzc;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zze {
    public static final String VERSION;
    public static final String zzQm;

    static {
        VERSION = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        zzQm = "ma" + VERSION;
    }
}
