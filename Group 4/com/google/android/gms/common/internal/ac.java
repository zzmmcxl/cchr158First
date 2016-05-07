/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.au;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.y;

public final class ac
extends au {
    private y a;
    private final int b;

    public ac(y y2, int n2) {
        this.a = y2;
        this.b = n2;
    }

    private void a() {
        this.a = null;
    }

    @Override
    public void a(int n2, Bundle bundle) {
        Log.wtf((String)"GmsClient", (String)"received deprecated onAccountValidationComplete callback, ignoring", (Throwable)new Exception());
    }

    @Override
    public void a(int n2, IBinder iBinder, Bundle bundle) {
        bf.a(this.a, (Object)"onPostInitComplete can be called only once per call to getRemoteService");
        this.a.a(n2, iBinder, bundle, this.b);
        this.a();
    }
}

