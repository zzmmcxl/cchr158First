/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.l;
import com.google.android.gms.common.api.c;

public class k
implements c {
    private final SignInConfiguration a;

    private k(SignInConfiguration signInConfiguration) {
        this.a = signInConfiguration;
    }

    /* synthetic */ k(SignInConfiguration signInConfiguration, l l2) {
        this(signInConfiguration);
    }

    public SignInConfiguration a() {
        return this.a;
    }
}

