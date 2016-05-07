/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.ak;

public abstract class aj {
    private static final Object a = new Object();
    private static aj b;

    /*
     * Enabled unnecessary exception pruning
     */
    public static aj a(Context context) {
        Object object = a;
        // MONITORENTER : object
        if (b == null) {
            b = new ak(context.getApplicationContext());
        }
        // MONITOREXIT : object
        return b;
    }

    public abstract boolean a(String var1, ServiceConnection var2, String var3);

    public abstract void b(String var1, ServiceConnection var2, String var3);
}

