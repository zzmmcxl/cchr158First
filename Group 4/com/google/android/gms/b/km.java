/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

public class km {
    public static int a(byte[] arrby, int n2, int n3, int n4) {
        int n5;
        int n6 = n2 + (n3 & -4);
        int n7 = n4;
        while (n2 < n6) {
            int n8 = -862048943 * (255 & arrby[n2] | (255 & arrby[n2 + 1]) << 8 | (255 & arrby[n2 + 2]) << 16 | arrby[n2 + 3] << 24);
            int n9 = n7 ^ 461845907 * (n8 << 15 | n8 >>> 17);
            n7 = -430675100 + 5 * (n9 << 13 | n9 >>> 19);
            n2 += 4;
        }
        int n10 = n3 & 3;
        int n11 = 0;
        switch (n10) {
            default: {
                n5 = n7;
                break;
            }
            case 3: {
                n11 = (255 & arrby[n6 + 2]) << 16;
            }
            case 2: {
                n11 |= (255 & arrby[n6 + 1]) << 8;
            }
            case 1: {
                int n12 = -862048943 * (n11 | 255 & arrby[n6]);
                n5 = n7 ^ 461845907 * (n12 << 15 | n12 >>> 17);
            }
        }
        int n13 = n5 ^ n3;
        int n14 = -2048144789 * (n13 ^ n13 >>> 16);
        int n15 = -1028477387 * (n14 ^ n14 >>> 13);
        return n15 ^ n15 >>> 16;
    }
}

