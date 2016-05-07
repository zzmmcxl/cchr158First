/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class h
implements ServiceConnection {
    boolean a = false;
    private final BlockingQueue b = new LinkedBlockingQueue();

    public IBinder a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        }
        if (this.a) {
            throw new IllegalStateException();
        }
        this.a = true;
        return (IBinder)this.b.take();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

