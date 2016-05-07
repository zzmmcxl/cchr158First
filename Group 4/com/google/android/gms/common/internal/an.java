/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.ak;
import com.google.android.gms.common.internal.am;
import java.util.HashMap;
import java.util.Iterator;

public class an
implements ServiceConnection {
    final /* synthetic */ am a;

    public an(am am2) {
        this.a = am2;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap = ak.a(this.a.a);
        // MONITORENTER : hashMap
        am.a(this.a, iBinder);
        am.a(this.a, componentName);
        Iterator iterator = am.b(this.a).iterator();
        while (iterator.hasNext()) {
            ((ServiceConnection)iterator.next()).onServiceConnected(componentName, iBinder);
        }
        am.a(this.a, 1);
        // MONITOREXIT : hashMap
        return;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap = ak.a(this.a.a);
        // MONITORENTER : hashMap
        am.a(this.a, null);
        am.a(this.a, componentName);
        Iterator iterator = am.b(this.a).iterator();
        while (iterator.hasNext()) {
            ((ServiceConnection)iterator.next()).onServiceDisconnected(componentName);
        }
        am.a(this.a, 2);
        // MONITOREXIT : hashMap
        return;
    }
}

