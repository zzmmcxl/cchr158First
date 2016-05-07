/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.ab;
import com.google.android.gms.common.api.internal.aa;
import com.google.android.gms.common.api.internal.ai;
import com.google.android.gms.common.api.internal.aj;
import java.lang.ref.WeakReference;

class ag
implements IBinder.DeathRecipient,
ai {
    private final WeakReference a;
    private final WeakReference b;
    private final WeakReference c;

    private ag(aj aj2, ab ab2, IBinder iBinder) {
        this.b = new WeakReference<ab>(ab2);
        this.a = new WeakReference<aj>(aj2);
        this.c = new WeakReference<IBinder>(iBinder);
    }

    /* synthetic */ ag(aj aj2, ab ab2, IBinder iBinder, aa aa2) {
        this(aj2, ab2, iBinder);
    }

    private void a() {
        aj aj2 = (aj)this.a.get();
        ab ab2 = (ab)this.b.get();
        if (ab2 != null && aj2 != null) {
            ab2.a(aj2.a());
        }
        IBinder iBinder = (IBinder)this.c.get();
        if (this.c == null) return;
        iBinder.unlinkToDeath((IBinder.DeathRecipient)this, 0);
    }

    @Override
    public void a(aj aj2) {
        this.a();
    }

    public void binderDied() {
        this.a();
    }
}

