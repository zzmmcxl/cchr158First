/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

@Deprecated
public final class p {
    public static int a(int n2) {
        if (n2 >= 0) {
            if (n2 <= 1) return n2;
        }
        if (1000 > n2) return 1;
        if (n2 > 1002) return 1;
        return n2;
    }

    public static Status b(int n2) {
        switch (n2) {
            default: {
                return new Status(n2);
            }
            case 1: 
        }
        n2 = 13;
        return new Status(n2);
    }
}

