/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.bc;
import android.support.v4.b.m;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.api.signin.internal.a;
import com.google.android.gms.auth.api.signin.internal.d;
import com.google.android.gms.common.api.n;
import java.util.Set;

class b
implements bc {
    final /* synthetic */ SignInHubActivity a;

    private b(SignInHubActivity signInHubActivity) {
        this.a = signInHubActivity;
    }

    /* synthetic */ b(SignInHubActivity signInHubActivity, a a2) {
        this(signInHubActivity);
    }

    @Override
    public m a(int n2, Bundle bundle) {
        return new d((Context)this.a, n.a());
    }

    @Override
    public void a(m m2) {
    }

    @Override
    public /* synthetic */ void a(m m2, Object object) {
        this.a(m2, (Void)object);
    }

    public void a(m m2, Void void_) {
        this.a.setResult(SignInHubActivity.a(this.a), SignInHubActivity.b(this.a));
        this.a.finish();
    }
}

