/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.bf;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class d {
    private Set a = new HashSet();
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private Account f;
    private String g;

    public d() {
    }

    public d(GoogleSignInOptions googleSignInOptions) {
        bf.a(googleSignInOptions);
        this.a = new HashSet(GoogleSignInOptions.a(googleSignInOptions));
        this.b = GoogleSignInOptions.b(googleSignInOptions);
        this.c = GoogleSignInOptions.c(googleSignInOptions);
        this.d = GoogleSignInOptions.d(googleSignInOptions);
        this.e = GoogleSignInOptions.e(googleSignInOptions);
        this.f = GoogleSignInOptions.f(googleSignInOptions);
        this.g = GoogleSignInOptions.g(googleSignInOptions);
    }

    public d a() {
        this.a.add(GoogleSignInOptions.c);
        return this;
    }

    public /* varargs */ d a(Scope scope, Scope ... arrscope) {
        this.a.add(scope);
        this.a.addAll(Arrays.asList(arrscope));
        return this;
    }

    public d b() {
        this.a.add(GoogleSignInOptions.a);
        return this;
    }

    public GoogleSignInOptions c() {
        if (!this.d) return new GoogleSignInOptions(this.a, this.f, this.d, this.b, this.c, this.e, this.g, null);
        if (this.f != null) {
            if (this.a.isEmpty()) return new GoogleSignInOptions(this.a, this.f, this.d, this.b, this.c, this.e, this.g, null);
        }
        this.a();
        return new GoogleSignInOptions(this.a, this.f, this.d, this.b, this.c, this.e, this.g, null);
    }
}

