/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.auth.api.signin.internal.ac;
import com.google.android.gms.auth.api.signin.internal.l;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.e;

public class v
extends l {
    private final Context a;

    public v(Context context) {
        this.a = context;
    }

    private void b() {
        if (e.b(this.a, Binder.getCallingUid())) return;
        throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
    }

    private void c() {
        ac ac2 = ac.a(this.a);
        GoogleSignInAccount googleSignInAccount = ac2.a();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.d;
        if (googleSignInAccount != null) {
            googleSignInOptions = ac2.b();
        }
        n n2 = new o(this.a).a(a.j, googleSignInOptions).b();
        try {
            if (!n2.f().b()) return;
            if (googleSignInAccount != null) {
                a.q.a(n2);
                return;
            }
            n2.h();
            return;
        }
        finally {
            n2.g();
        }
    }

    @Override
    public void a() {
        this.b();
        this.c();
    }
}

