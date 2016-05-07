/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import java.io.PrintWriter;

public final class s {
    private static final Object a = new Object();
    private static char[] b = new char[24];

    private static int a(int n2, int n3, boolean bl2, int n4) {
        if (n2 > 99) return n3 + 3;
        if (bl2 && n4 >= 3) {
            return n3 + 3;
        }
        if (n2 > 9) return n3 + 2;
        if (bl2 && n4 >= 2) {
            return n3 + 2;
        }
        if (bl2) return n3 + 1;
        if (n2 <= 0) return 0;
        return n3 + 1;
    }

    private static int a(long l2, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        if (b.length < n2) {
            b = new char[n2];
        }
        char[] arrc = b;
        if (l2 == 0) {
            int n9 = n2 - 1;
            do {
                if (n9 >= 0) {
                    arrc[0] = 48;
                    return 1;
                }
                arrc[0] = 32;
            } while (true);
        }
        if (l2 > 0) {
            n8 = 43;
        } else {
            l2 = - l2;
            n8 = 45;
        }
        int n10 = (int)(l2 % 1000);
        int n11 = (int)Math.floor(l2 / 1000);
        int n12 = 0;
        if (n11 > 86400) {
            n12 = n11 / 86400;
            n11 -= 86400 * n12;
        }
        if (n11 > 3600) {
            int n13 = n11 / 3600;
            int n14 = n11 - n13 * 3600;
            n4 = n13;
            n7 = n14;
        } else {
            n7 = n11;
            n4 = 0;
        }
        if (n7 > 60) {
            int n15 = n7 / 60;
            int n16 = n7 - n15 * 60;
            n3 = n15;
            n6 = n16;
        } else {
            n6 = n7;
            n3 = 0;
        }
        if (n2 != 0) {
            int n17 = s.a(n12, 1, false, 0);
            boolean bl2 = n17 > 0;
            int n18 = n17 + s.a(n4, 1, bl2, 2);
            boolean bl3 = n18 > 0;
            int n19 = n18 + s.a(n3, 1, bl3, 2);
            boolean bl4 = n19 > 0;
            int n20 = n19 + s.a(n6, 1, bl4, 2);
            int n21 = n20 > 0 ? 3 : 0;
            int n22 = n20 + (1 + s.a(n10, 2, true, n21));
            n5 = 0;
            for (int i2 = n22; i2 < n2; ++i2) {
                arrc[n5] = 32;
                int n23 = n5 + 1;
                n5 = n23;
            }
        } else {
            n5 = 0;
        }
        arrc[n5] = n8;
        int n24 = n5 + 1;
        boolean bl5 = n2 != 0;
        int n25 = s.a(arrc, n12, 'd', n24, false, 0);
        boolean bl6 = n25 != n24;
        int n26 = bl5 ? 2 : 0;
        int n27 = s.a(arrc, n4, 'h', n25, bl6, n26);
        boolean bl7 = n27 != n24;
        int n28 = bl5 ? 2 : 0;
        int n29 = s.a(arrc, n3, 'm', n27, bl7, n28);
        boolean bl8 = n29 != n24;
        int n30 = bl5 ? 2 : 0;
        int n31 = s.a(arrc, n6, 's', n29, bl8, n30);
        int n32 = bl5 && n31 != n24 ? 3 : 0;
        int n33 = s.a(arrc, n10, 'm', n31, true, n32);
        arrc[n33] = 115;
        return n33 + 1;
    }

    private static int a(char[] arrc, int n2, char c2, int n3, boolean bl2, int n4) {
        int n5;
        int n6;
        if (!bl2) {
            if (n2 <= 0) return n3;
        }
        if (bl2 && n4 >= 3 || n2 > 99) {
            int n7 = n2 / 100;
            arrc[n3] = (char)(n7 + 48);
            n5 = n3 + 1;
            n6 = n2 - n7 * 100;
        } else {
            n5 = n3;
            n6 = n2;
        }
        if (bl2 && n4 >= 2 || n6 > 9 || n3 != n5) {
            int n8 = n6 / 10;
            arrc[n5] = (char)(n8 + 48);
            ++n5;
            n6 -= n8 * 10;
        }
        arrc[n5] = (char)(n6 + 48);
        int n9 = n5 + 1;
        arrc[n9] = c2;
        return n9 + 1;
    }

    public static void a(long l2, long l3, PrintWriter printWriter) {
        if (l2 == 0) {
            printWriter.print("--");
            return;
        }
        s.a(l2 - l3, printWriter, 0);
    }

    public static void a(long l2, PrintWriter printWriter) {
        s.a(l2, printWriter, 0);
    }

    public static void a(long l2, PrintWriter printWriter, int n2) {
        Object object = a;
        // MONITORENTER : object
        int n3 = s.a(l2, n2);
        printWriter.print(new String(b, 0, n3));
        // MONITOREXIT : object
        return;
    }
}

