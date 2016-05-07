/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.ac;
import com.google.android.gms.location.internal.o;
import com.google.android.gms.location.internal.v;
import com.google.android.gms.location.internal.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class u {
    private final ac a;
    private final Context b;
    private ContentProviderClient c = null;
    private boolean d = false;
    private Map e = new HashMap();
    private Map f = new HashMap();

    public u(Context context, ac ac2) {
        this.b = context;
        this.a = ac2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void a() {
        Map map = this.e;
        // MONITORENTER : map
        for (w w2 : this.e.values()) {
            if (w2 == null) continue;
            ((o)this.a.c()).a(LocationRequestUpdateData.a(w2, null));
        }
        this.e.clear();
        // MONITOREXIT : map
        try {
            Map map2 = this.f;
            // MONITORENTER : map2
        }
        catch (RemoteException var1_4) {
            throw new IllegalStateException((Throwable)var1_4);
        }
        Iterator iterator = this.f.values().iterator();
        do {
            if (!iterator.hasNext()) {
                this.f.clear();
                // MONITOREXIT : map2
                return;
            }
            v v2 = (v)iterator.next();
            if (v2 == null) continue;
            ((o)this.a.c()).a(LocationRequestUpdateData.a(v2, null));
        } while (true);
    }

    public void a(boolean bl2) {
        this.a.a();
        ((o)this.a.c()).a(bl2);
        this.d = bl2;
    }

    public void b() {
        if (!this.d) return;
        try {
            this.a(false);
            return;
        }
        catch (RemoteException var1_1) {
            throw new IllegalStateException((Throwable)var1_1);
        }
    }
}

