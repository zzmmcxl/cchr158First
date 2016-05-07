/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.am;

final class an
extends Handler {
    final /* synthetic */ al a;

    an(al al2, Looper looper) {
        this.a = al2;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            default: {
                Log.w((String)"GACStateManager", (String)("Unknown message id: " + message.what));
                return;
            }
            case 1: {
                ((am)message.obj).a(this.a);
                return;
            }
            case 2: 
        }
        throw (RuntimeException)message.obj;
    }
}

