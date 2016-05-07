/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.util.Arrays;

public final class mk {
    public static final Object a = new Object();

    public static int a(long[] arrl) {
        if (arrl == null) return 0;
        if (arrl.length != 0) return Arrays.hashCode(arrl);
        return 0;
    }

    public static int a(Object[] arrobject) {
        int n2 = 0;
        int n3 = arrobject == null ? 0 : arrobject.length;
        int n4 = 0;
        while (n4 < n3) {
            Object object = arrobject[n4];
            if (object != null) {
                n2 = n2 * 31 + object.hashCode();
            }
            ++n4;
        }
        return n2;
    }

    public static boolean a(long[] arrl, long[] arrl2) {
        if (arrl != null) {
            if (arrl.length != 0) return Arrays.equals(arrl, arrl2);
        }
        if (arrl2 == null) return true;
        if (arrl2.length != 0) return false;
        return true;
    }

    public static boolean a(Object[] arrobject, Object[] arrobject2) {
        int n2 = arrobject == null ? 0 : arrobject.length;
        int n3 = arrobject2 == null ? 0 : arrobject2.length;
        int n4 = 0;
        int n5 = 0;
        do {
            int n6;
            if (n5 < n2 && arrobject[n5] == null) {
                ++n5;
                continue;
            }
            for (n6 = n4; n6 < n3 && arrobject2[n6] == null; ++n6) {
            }
            boolean bl2 = n5 >= n2;
            boolean bl3 = n6 >= n3;
            if (bl2 && bl3) {
                return true;
            }
            boolean bl4 = false;
            if (bl2 != bl3) return bl4;
            boolean bl5 = arrobject[n5].equals(arrobject2[n6]);
            bl4 = false;
            if (!bl5) return bl4;
            int n7 = n5 + 1;
            n4 = n6 + 1;
            n5 = n7;
        } while (true);
    }
}

