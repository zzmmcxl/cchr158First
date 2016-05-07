/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.b.p;
import android.support.v4.b.u;

class v
extends Handler {
    public v() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        u u2 = (u)message.obj;
        switch (message.what) {
            default: {
                return;
            }
            case 1: {
                p.c(u2.a, u2.b[0]);
                return;
            }
            case 2: 
        }
        u2.a.b(u2.b);
    }
}

