/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.i;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class g
extends com.google.android.gms.common.api.g {
    g() {
    }

    public i a(Context context, Looper looper, t t2, GoogleSignInOptions googleSignInOptions, q q2, r r2) {
        return new i(context, looper, t2, googleSignInOptions, q2, r2);
    }

    public List a(GoogleSignInOptions googleSignInOptions) {
        if (googleSignInOptions != null) return googleSignInOptions.a();
        return Collections.emptyList();
    }

    @Override
    public /* synthetic */ List a(Object object) {
        return this.a((GoogleSignInOptions)object);
    }
}

