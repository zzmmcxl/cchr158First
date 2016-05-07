/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class a
implements Comparator {
    a() {
    }

    public int a(Scope scope, Scope scope2) {
        return scope.a().compareTo(scope2.a());
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((Scope)object, (Scope)object2);
    }
}

