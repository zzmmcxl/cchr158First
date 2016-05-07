/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.z;

final class af
extends Handler {
    final /* synthetic */ z a;

    af(z z2, Looper looper) {
        this.a = z2;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            default: {
                Log.w((String)"GoogleApiClientImpl", (String)("Unknown message id: " + message.what));
                return;
            }
            case 1: {
                z.c(this.a);
                return;
            }
            case 2: 
        }
        z.b(this.a);
    }
}

