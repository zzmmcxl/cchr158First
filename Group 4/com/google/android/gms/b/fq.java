/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.fi;

@fi
public class fq
extends Handler {
    public fq(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
            return;
        }
        catch (Exception var2_2) {
            g.f().a(var2_2, false);
            throw var2_2;
        }
    }
}

