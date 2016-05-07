/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.v;

public final class RevocationBoundService
extends Service {
    public IBinder onBind(Intent intent) {
        if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction())) {
            if (!Log.isLoggable((String)"RevocationService", (int)2)) return new v((Context)this);
            Log.v((String)"RevocationService", (String)"RevocationBoundService handling disconnect.");
            return new v((Context)this);
        }
        Log.w((String)"RevocationService", (String)("Unknown action sent to RevocationBoundService: " + intent.getAction()));
        return null;
    }
}

