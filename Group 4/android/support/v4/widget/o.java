/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.widget.m;

class o
extends ContentObserver {
    final /* synthetic */ m a;

    public o(m m2) {
        this.a = m2;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean bl2) {
        this.a.b();
    }
}

