/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.aa;
import com.google.android.gms.common.api.internal.aw;
import com.google.android.gms.common.api.internal.be;
import com.google.android.gms.common.api.internal.bf;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;
import com.google.android.gms.common.api.y;
import com.google.android.gms.common.api.z;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

public class bd
extends aa
implements x {
    private z a;
    private bd b;
    private y c;
    private t d;
    private final Object e;
    private Status f;
    private final WeakReference g;
    private final bf h;

    static /* synthetic */ z a(bd bd2) {
        return bd2.a;
    }

    private void a(Status status) {
        Object object = this.e;
        // MONITORENTER : object
        this.f = status;
        this.b(this.f);
        // MONITOREXIT : object
        return;
    }

    static /* synthetic */ void a(bd bd2, Status status) {
        bd2.a(status);
    }

    static /* synthetic */ void a(bd bd2, w w2) {
        bd2.b(w2);
    }

    static /* synthetic */ bf b(bd bd2) {
        return bd2.h;
    }

    private void b() {
        if (this.a == null && this.c == null) {
            return;
        }
        n n2 = (n)this.g.get();
        if (this.a != null && n2 != null) {
            n2.a(this);
        }
        if (this.f != null) {
            this.b(this.f);
            return;
        }
        if (this.d == null) return;
        this.d.a(this);
    }

    private void b(Status status) {
        Object object = this.e;
        // MONITORENTER : object
        if (this.a != null) {
            Status status2 = this.a.a(status);
            com.google.android.gms.common.internal.bf.a(status2, (Object)"onFailure must not return null");
            this.b.a(status2);
            return;
        } else if (this.c()) {
            this.c.a(status);
            return;
        }
        // MONITOREXIT : object
        return;
    }

    private void b(w w2) {
        if (!(w2 instanceof v)) return;
        try {
            ((v)((Object)w2)).a();
            return;
        }
        catch (RuntimeException var2_2) {
            Log.w((String)"TransformedResultImpl", (String)("Unable to release " + w2), (Throwable)var2_2);
            return;
        }
    }

    static /* synthetic */ WeakReference c(bd bd2) {
        return bd2.g;
    }

    private boolean c() {
        n n2 = (n)this.g.get();
        if (this.c == null) return false;
        if (n2 == null) return false;
        return true;
    }

    static /* synthetic */ Object d(bd bd2) {
        return bd2.e;
    }

    static /* synthetic */ bd e(bd bd2) {
        return bd2.b;
    }

    void a() {
        Object object = this.e;
        // MONITORENTER : object
        this.c = null;
        // MONITOREXIT : object
        return;
    }

    public void a(t t2) {
        Object object = this.e;
        // MONITORENTER : object
        this.d = t2;
        this.b();
        // MONITOREXIT : object
        return;
    }

    @Override
    public void a(w w2) {
        Object object = this.e;
        // MONITORENTER : object
        if (w2.a().e()) {
            if (this.a != null) {
                aw.a().submit(new be(this, w2));
                return;
            } else if (this.c()) {
                this.c.b(w2);
                return;
            }
            // MONITOREXIT : object
            return;
        }
        this.a(w2.a());
        this.b(w2);
        return;
    }
}

