/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.u;

class v
extends u {
    private Handler a;

    private void a(int n2, Object object) {
        if (this.a == null) {
            Log.e((String)"LocationClientHelper", (String)"Received a data in client after calling removeLocationUpdates.");
            return;
        }
        Message message = Message.obtain();
        message.what = n2;
        message.obj = object;
        this.a.sendMessage(message);
    }

    @Override
    public void a(LocationAvailability locationAvailability) {
        this.a(1, locationAvailability);
    }

    @Override
    public void a(LocationResult locationResult) {
        this.a(0, locationResult);
    }
}

