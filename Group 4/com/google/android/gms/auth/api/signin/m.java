/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.k;
import com.google.android.gms.auth.api.signin.l;
import com.google.android.gms.common.internal.bf;

public class m {
    private final SignInConfiguration a;

    public m(String string) {
        bf.a(string);
        this.a = new SignInConfiguration(string);
    }

    public k a() {
        boolean bl2 = this.a.c() != null || this.a.d() != null;
        bf.a(bl2, (Object)"Must support either Facebook, Google or Email sign-in.");
        return new k(this.a, null);
    }

    public m a(GoogleSignInOptions googleSignInOptions) {
        bf.a(googleSignInOptions);
        this.a.a(googleSignInOptions);
        return this;
    }
}

