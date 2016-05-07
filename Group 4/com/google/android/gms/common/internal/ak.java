/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.aj;
import com.google.android.gms.common.internal.al;
import com.google.android.gms.common.internal.am;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.stats.b;
import java.util.HashMap;

final class ak
extends aj
implements Handler.Callback {
    private final HashMap a = new HashMap();
    private final Context b;
    private final Handler c;
    private final b d;
    private final long e;

    ak(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(context.getMainLooper(), (Handler.Callback)this);
        this.d = b.a();
        this.e = 5000;
    }

    static /* synthetic */ HashMap a(ak ak2) {
        return ak2.a;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private boolean a(al al2, ServiceConnection serviceConnection, String string) {
        bf.a((Object)serviceConnection, (Object)"ServiceConnection must not be null");
        HashMap hashMap = this.a;
        // MONITORENTER : hashMap
        am am2 = (am)this.a.get(al2);
        if (am2 == null) {
            am2 = new am(this, al2);
            am2.a(serviceConnection, string);
            am2.a(string);
            this.a.put(al2, am2);
        } else {
            this.c.removeMessages(0, (Object)am2);
            if (am2.a(serviceConnection)) {
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + al2);
            }
            am2.a(serviceConnection, string);
            switch (am2.b()) {
                case 1: {
                    serviceConnection.onServiceConnected(am2.e(), am2.d());
                    break;
                }
                case 2: {
                    am2.a(string);
                    break;
                }
            }
        }
        boolean bl2 = am2.a();
        // MONITOREXIT : hashMap
        return bl2;
    }

    static /* synthetic */ Context b(ak ak2) {
        return ak2.b;
    }

    private void b(al al2, ServiceConnection serviceConnection, String string) {
        bf.a((Object)serviceConnection, (Object)"ServiceConnection must not be null");
        HashMap hashMap = this.a;
        // MONITORENTER : hashMap
        am am2 = (am)this.a.get(al2);
        if (am2 == null) {
            throw new IllegalStateException("Nonexistent connection status for service config: " + al2);
        }
        if (!am2.a(serviceConnection)) {
            throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + al2);
        }
        am2.b(serviceConnection, string);
        if (am2.c()) {
            Message message = this.c.obtainMessage(0, (Object)am2);
            this.c.sendMessageDelayed(message, this.e);
        }
        // MONITOREXIT : hashMap
    }

    static /* synthetic */ b c(ak ak2) {
        return ak2.d;
    }

    @Override
    public boolean a(String string, ServiceConnection serviceConnection, String string2) {
        return this.a(new al(string), serviceConnection, string2);
    }

    @Override
    public void b(String string, ServiceConnection serviceConnection, String string2) {
        this.b(new al(string), serviceConnection, string2);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            default: {
                return false;
            }
            case 0: 
        }
        am am2 = (am)message.obj;
        HashMap hashMap = this.a;
        // MONITORENTER : hashMap
        if (am2.c()) {
            if (am2.a()) {
                am2.b("GmsClientSupervisor");
            }
            this.a.remove(am.a(am2));
        }
        // MONITOREXIT : hashMap
        return true;
    }
}

