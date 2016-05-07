/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.bd;
import com.google.android.gms.common.internal.bf;
import java.util.ArrayList;
import java.util.List;

public final class be {
    private final List a;
    private final Object b;

    private be(Object object) {
        this.b = bf.a(object);
        this.a = new ArrayList();
    }

    /* synthetic */ be(Object object, bd bd2) {
        this(object);
    }

    public be a(String string, Object object) {
        this.a.add((String)bf.a((Object)string) + "=" + String.valueOf(object));
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
        int n2 = this.a.size();
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append((String)this.a.get(n3));
            if (n3 < n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        return stringBuilder.append('}').toString();
    }
}

