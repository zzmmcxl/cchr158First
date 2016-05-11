package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzoc.zza;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzoe.zzb;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpf;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzpi;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API;
    public static final Api<NoOptions> BLE_API;
    public static final BleApi BleApi;
    public static final Api<NoOptions> CONFIG_API;
    public static final ConfigApi ConfigApi;
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api<NoOptions> HISTORY_API;
    public static final HistoryApi HistoryApi;
    public static final Api<NoOptions> RECORDING_API;
    public static final RecordingApi RecordingApi;
    public static final Scope SCOPE_ACTIVITY_READ;
    public static final Scope SCOPE_ACTIVITY_READ_WRITE;
    public static final Scope SCOPE_BODY_READ;
    public static final Scope SCOPE_BODY_READ_WRITE;
    public static final Scope SCOPE_LOCATION_READ;
    public static final Scope SCOPE_LOCATION_READ_WRITE;
    public static final Scope SCOPE_NUTRITION_READ;
    public static final Scope SCOPE_NUTRITION_READ_WRITE;
    public static final Api<NoOptions> SENSORS_API;
    public static final Api<NoOptions> SESSIONS_API;
    public static final SensorsApi SensorsApi;
    public static final SessionsApi SessionsApi;
    public static final Api<NoOptions> zzaoG;
    public static final zzc<zznz> zzavK;
    public static final zzc<zzoa> zzavL;
    public static final zzc<zzob> zzavM;
    public static final zzc<zzoc> zzavN;
    public static final zzc<zzod> zzavO;
    public static final zzc<zzoe> zzavP;
    public static final zzc<zzof> zzavQ;
    public static final zzoy zzavR;

    static {
        zzavK = new zzc();
        zzavL = new zzc();
        zzavM = new zzc();
        zzavN = new zzc();
        zzavO = new zzc();
        zzavP = new zzc();
        zzavQ = new zzc();
        API = null;
        SENSORS_API = new Api("Fitness.SENSORS_API", new zzb(), zzavP);
        SensorsApi = new zzpf();
        RECORDING_API = new Api("Fitness.RECORDING_API", new zzod.zzb(), zzavO);
        RecordingApi = new zzpe();
        SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzof.zzb(), zzavQ);
        SessionsApi = new zzpg();
        HISTORY_API = new Api("Fitness.HISTORY_API", new zzob.zzb(), zzavM);
        HistoryApi = new zzpc();
        CONFIG_API = new Api("Fitness.CONFIG_API", new zzoa.zzb(), zzavL);
        ConfigApi = new zzpb();
        BLE_API = new Api("Fitness.BLE_API", new zznz.zzb(), zzavK);
        BleApi = zztZ();
        zzaoG = new Api("Fitness.INTERNAL_API", new zza(), zzavN);
        zzavR = new zzpd();
        SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
        SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
        SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
        SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
        SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
        SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
        SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
        SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
    }

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zztZ() {
        return VERSION.SDK_INT >= 18 ? new zzpa() : new zzpi();
    }
}
