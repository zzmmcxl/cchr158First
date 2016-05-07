/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.auth.api.signin.internal.ac;
import com.google.android.gms.auth.api.signin.internal.f;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.t;
import java.util.Iterator;

public class e
implements b {
    @Override
    public t a(n n2) {
        ac.a(n2.b()).d();
        Iterator iterator = n.a().iterator();
        while (iterator.hasNext()) {
            ((n)iterator.next()).d();
        }
        return n2.a(new f(this, n2));
    }
}

