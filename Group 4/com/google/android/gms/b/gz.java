/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@fi
class gz {
    private final Object a = new Object();
    private final List b = new ArrayList();
    private final List c = new ArrayList();
    private boolean d = false;

    private void b(Runnable runnable) {
        fr.a(runnable);
    }

    private void c(Runnable runnable) {
        a.a.post(runnable);
    }

    public void a() {
        Object object = this.a;
        // MONITORENTER : object
        if (this.d) {
            // MONITOREXIT : object
            return;
        }
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            this.b((Runnable)iterator.next());
        }
        Iterator iterator2 = this.c.iterator();
        do {
            if (!iterator2.hasNext()) {
                this.b.clear();
                this.c.clear();
                this.d = true;
                // MONITOREXIT : object
                return;
            }
            this.c((Runnable)iterator2.next());
        } while (true);
    }

    public void a(Runnable runnable) {
        Object object = this.a;
        // MONITORENTER : object
        if (this.d) {
            this.c(runnable);
            // MONITOREXIT : object
            return;
        }
        this.c.add(runnable);
        return;
    }
}

