/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.y;

abstract class z
extends ab {
    public final int a;
    public final Bundle b;
    final /* synthetic */ y c;

    protected z(y y2, int n2, Bundle bundle) {
        this.c = y2;
        super(y2, true);
        this.a = n2;
        this.b = bundle;
    }

    protected abstract void a(ConnectionResult var1);

    protected void a(Boolean bl2) {
        if (bl2 == null) {
            y.a(this.c, 1, null);
            return;
        }
        switch (this.a) {
            default: {
                y.a(this.c, 1, null);
                Bundle bundle = this.b;
                PendingIntent pendingIntent = null;
                if (bundle != null) {
                    pendingIntent = (PendingIntent)this.b.getParcelable("pendingIntent");
                }
                this.a(new ConnectionResult(this.a, pendingIntent));
                return;
            }
            case 0: {
                if (this.a()) return;
                y.a(this.c, 1, null);
                this.a(new ConnectionResult(8, null));
                return;
            }
            case 10: 
        }
        y.a(this.c, 1, null);
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }

    @Override
    protected /* synthetic */ void a(Object object) {
        this.a((Boolean)object);
    }

    protected abstract boolean a();

    @Override
    protected void b() {
    }
}

