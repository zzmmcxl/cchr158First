/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.ax;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.y;

public final class ad
implements ServiceConnection {
    final /* synthetic */ y a;
    private final int b;

    public ad(y y2, int n2) {
        this.a = y2;
        this.b = n2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        bf.a((Object)iBinder, (Object)"Expecting a valid IBinder");
        Object object = y.a(this.a);
        // MONITORENTER : object
        y.a(this.a, ax.a(iBinder));
        // MONITOREXIT : object
        this.a.a(0, this.b);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onServiceDisconnected(ComponentName componentName) {
        Object object = y.a(this.a);
        // MONITORENTER : object
        y.a(this.a, null);
        // MONITOREXIT : object
        this.a.a.sendMessage(this.a.a.obtainMessage(4, this.b, 1));
    }
}

