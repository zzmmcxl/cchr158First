/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.aa;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.ap;
import com.google.android.gms.common.api.internal.ba;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.j;

@KeepName
public class SupportLifecycleFragmentImpl
extends ba {
    @Override
    protected /* synthetic */ j K() {
        return this.a();
    }

    protected b a() {
        return b.a();
    }

    @Override
    protected void a(int n2, ConnectionResult connectionResult) {
        e.a(connectionResult.c(), this.g(), this, 2, this);
    }

    @Override
    protected void b(int n2, ConnectionResult connectionResult) {
        Dialog dialog = this.a().a(this.g(), this);
        this.a = ap.a(this.g().getApplicationContext(), new a(this, dialog));
    }
}

