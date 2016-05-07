/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.y;
import java.util.concurrent.atomic.AtomicInteger;

final class aa
extends Handler {
    final /* synthetic */ y a;

    public aa(y y2, Looper looper) {
        this.a = y2;
        super(looper);
    }

    private void a(Message message) {
        ab ab2 = (ab)message.obj;
        ab2.b();
        ab2.d();
    }

    private boolean b(Message message) {
        if (message.what == 2) return true;
        if (message.what == 1) return true;
        if (message.what != 5) return false;
        return true;
    }

    public void handleMessage(Message message) {
        if (this.a.b.get() != message.arg1) {
            if (!this.b(message)) return;
            this.a(message);
            return;
        }
        if (!(message.what != 1 && message.what != 5 || this.a.m())) {
            this.a(message);
            return;
        }
        if (message.what == 3) {
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, null);
            y.b(this.a).a(connectionResult);
            this.a.a(connectionResult);
            return;
        }
        if (message.what == 4) {
            y.a(this.a, 4, null);
            if (y.c(this.a) != null) {
                y.c(this.a).a(message.arg2);
            }
            this.a.a(message.arg2);
            y.a(this.a, 4, 1, null);
            return;
        }
        if (message.what == 2 && !this.a.h()) {
            this.a(message);
            return;
        }
        if (this.b(message)) {
            ((ab)message.obj).c();
            return;
        }
        Log.wtf((String)"GmsClient", (String)("Don't know how to handle message: " + message.what), (Throwable)new Exception());
    }
}

