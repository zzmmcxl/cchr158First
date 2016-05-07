/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.internal.y;
import java.util.ArrayList;

public abstract class ab {
    private Object a;
    private boolean b;
    final /* synthetic */ y d;

    public ab(y y2, Object object) {
        this.d = y2;
        this.a = object;
        this.b = false;
    }

    protected abstract void a(Object var1);

    protected abstract void b();

    /*
     * Enabled unnecessary exception pruning
     */
    public void c() {
        // MONITORENTER : this
        Object object = this.a;
        if (this.b) {
            Log.w((String)"GmsClient", (String)("Callback proxy " + this + " being reused. This is not safe."));
        }
        // MONITOREXIT : this
        if (object != null) {
            try {
                this.a(object);
            }
            catch (RuntimeException var4_2) {
                this.b();
                throw var4_2;
            }
        } else {
            this.b();
        }
        // MONITORENTER : this
        this.b = true;
        // MONITOREXIT : this
        this.d();
    }

    public void d() {
        this.e();
        ArrayList arrayList = y.d(this.d);
        // MONITORENTER : arrayList
        y.d(this.d).remove(this);
        // MONITOREXIT : arrayList
        return;
    }

    public void e() {
        // MONITORENTER : this
        this.a = null;
        // MONITOREXIT : this
        return;
    }
}

