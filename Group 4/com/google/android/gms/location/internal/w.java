/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.x;

class w
extends x {
    private Handler a;

    @Override
    public void a(Location location) {
        if (this.a == null) {
            Log.e((String)"LocationClientHelper", (String)"Received a location in client after calling removeLocationUpdates.");
            return;
        }
        Message message = Message.obtain();
        message.what = 1;
        message.obj = location;
        this.a.sendMessage(message);
    }
}

