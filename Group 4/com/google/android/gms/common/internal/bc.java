/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.bd;
import com.google.android.gms.common.internal.be;
import java.util.Arrays;

public final class bc {
    public static /* varargs */ int a(Object ... arrobject) {
        return Arrays.hashCode(arrobject);
    }

    public static be a(Object object) {
        return new be(object, null);
    }

    public static boolean a(Object object, Object object2) {
        if (object == object2) return true;
        if (object == null) return false;
        if (!object.equals(object2)) return false;
        return true;
    }
}

