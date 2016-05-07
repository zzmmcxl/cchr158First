/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.ai;
import com.google.android.gms.common.api.internal.aj;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;
import com.google.android.gms.common.internal.bf;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c
extends e
implements aj,
d {
    private final i a;
    private AtomicReference b = new AtomicReference();

    protected c(i i2, n n2) {
        super((n)bf.a(n2, (Object)"GoogleApiClient must not be null"));
        this.a = (i)bf.a(i2);
    }

    private void a(RemoteException remoteException) {
        this.c(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    protected abstract void a(h var1);

    @Override
    public void a(ai ai2) {
        this.b.set(ai2);
    }

    @Override
    public /* synthetic */ void a(Object object) {
        super.a((w)object);
    }

    @Override
    public final i b() {
        return this.a;
    }

    @Override
    public final void b(h h2) {
        try {
            this.a(h2);
            return;
        }
        catch (DeadObjectException var3_2) {
            this.a((RemoteException)var3_2);
            throw var3_2;
        }
        catch (RemoteException var2_3) {
            this.a(var2_3);
            return;
        }
    }

    @Override
    public void c() {
        this.a((x)null);
    }

    @Override
    public final void c(Status status) {
        boolean bl2 = !status.e();
        bf.b(bl2, "Failed result must not be success");
        this.a(this.b(status));
    }

    @Override
    protected void d() {
        ai ai2 = this.b.getAndSet(null);
        if (ai2 == null) return;
        ai2.a(this);
    }
}

