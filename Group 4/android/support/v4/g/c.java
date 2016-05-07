/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

class c {
    static final int[] a = new int[0];
    static final long[] b = new long[0];
    static final Object[] c = new Object[0];

    public static int a(int n2) {
        return c.c(n2 * 4) / 4;
    }

    static int a(int[] arrn, int n2, int n3) {
        int n4 = 0;
        int n5 = n2 - 1;
        while (n4 <= n5) {
            int n6 = n4 + n5 >>> 1;
            int n7 = arrn[n6];
            if (n7 < n3) {
                n4 = n6 + 1;
                continue;
            }
            if (n7 <= n3) return n6;
            n5 = n6 - 1;
        }
        return ~ n4;
    }

    static int a(long[] arrl, int n2, long l2) {
        int n3 = 0;
        int n4 = n2 - 1;
        while (n3 <= n4) {
            int n5 = n3 + n4 >>> 1;
            long l3 = arrl[n5];
            if (l3 < l2) {
                n3 = n5 + 1;
                continue;
            }
            if (l3 <= l2) return n5;
            n4 = n5 - 1;
        }
        return ~ n3;
    }

    public static boolean a(Object object, Object object2) {
        if (object == object2) return true;
        if (object == null) return false;
        if (!object.equals(object2)) return false;
        return true;
    }

    public static int b(int n2) {
        return c.c(n2 * 8) / 8;
    }

    public static int c(int n2) {
        int n3 = 4;
        while (n3 < 32) {
            if (n2 <= -12 + (1 << n3)) {
                return -12 + (1 << n3);
            }
            ++n3;
        }
        return n2;
    }
}

