/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl;
import com.google.android.gms.common.api.internal.ap;

class a
extends ap {
    final /* synthetic */ Dialog a;
    final /* synthetic */ SupportLifecycleFragmentImpl b;

    a(SupportLifecycleFragmentImpl supportLifecycleFragmentImpl, Dialog dialog) {
        this.b = supportLifecycleFragmentImpl;
        this.a = dialog;
    }

    @Override
    protected void a() {
        this.b.L();
        this.a.dismiss();
    }
}

