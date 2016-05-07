/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.d;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.api.signin.internal.p;
import com.google.android.gms.auth.api.signin.internal.q;
import com.google.android.gms.auth.api.signin.k;
import com.google.android.gms.auth.api.signin.m;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;
import java.util.Iterator;
import java.util.Set;

public class i
extends y {
    private final GoogleSignInOptions d;

    public i(Context context, Looper looper, t t2, GoogleSignInOptions googleSignInOptions, com.google.android.gms.common.api.q q2, r r2) {
        super(context, looper, 91, t2, q2, r2);
        if (googleSignInOptions == null) {
            googleSignInOptions = new d().c();
        }
        if (!t2.e().isEmpty()) {
            d d2 = new d(googleSignInOptions);
            Iterator iterator = t2.e().iterator();
            while (iterator.hasNext()) {
                d2.a((Scope)iterator.next(), new Scope[0]);
            }
            googleSignInOptions = d2.c();
        }
        this.d = googleSignInOptions;
    }

    protected p a(IBinder iBinder) {
        return q.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override
    public boolean d() {
        return true;
    }

    @Override
    public Intent e() {
        SignInConfiguration signInConfiguration = new m(this.n().getPackageName()).a(this.d).a().a();
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(this.n(), (Class)SignInHubActivity.class);
        intent.putExtra("config", (Parcelable)signInConfiguration);
        return intent;
    }

    public GoogleSignInOptions f() {
        return this.d;
    }
}

