/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.am;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.gv;

@fi
public class al {
    private final Object a = new Object();
    private boolean b = false;
    private SharedPreferences c = null;

    static /* synthetic */ SharedPreferences a(al al2) {
        return al2.c;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public Object a(ae ae2) {
        Object object = this.a;
        // MONITORENTER : object
        if (!this.b) {
            Object object2 = ae2.b();
            // MONITOREXIT : object
            return object2;
        }
        // MONITOREXIT : object
        return gv.a(new am(this, ae2));
    }
}

