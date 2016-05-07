/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.v;
import java.util.Comparator;

class w
implements Comparator {
    final /* synthetic */ v a;

    w(v v2) {
        this.a = v2;
    }

    public int a(String string, String string2) {
        return string2.length() - string.length();
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((String)object, (String)object2);
    }
}

