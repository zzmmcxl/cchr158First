/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;

public class f
extends Handler {
    public f() {
        this(Looper.getMainLooper());
    }

    public f(Looper looper) {
        super(looper);
    }

    public void a() {
        this.removeMessages(2);
    }

    public void a(x x2, w w2) {
        this.sendMessage(this.obtainMessage(1, (Object)new Pair((Object)x2, (Object)w2)));
    }

    protected void b(x x2, w w2) {
        try {
            x2.a(w2);
            return;
        }
        catch (RuntimeException var3_3) {
            e.b(w2);
            throw var3_3;
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            default: {
                Log.wtf((String)"BasePendingResult", (String)("Don't know how to handle message: " + message.what), (Throwable)new Exception());
                return;
            }
            case 1: {
                Pair pair = (Pair)message.obj;
                this.b((x)pair.first, (w)pair.second);
                return;
            }
            case 2: 
        }
        ((e)message.obj).d(Status.d);
    }
}

