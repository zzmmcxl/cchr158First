/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class u {
    private static MessageDigest b = null;
    protected Object a = new Object();

    /*
     * Enabled unnecessary exception pruning
     */
    protected MessageDigest a() {
        Object object = this.a;
        // MONITORENTER : object
        if (b != null) {
            MessageDigest messageDigest = b;
            // MONITOREXIT : object
            return messageDigest;
        }
        int n2 = 0;
        do {
            if (n2 >= 2) {
                MessageDigest messageDigest = b;
                // MONITOREXIT : object
                return messageDigest;
            }
            try {
                b = MessageDigest.getInstance("MD5");
            }
            catch (NoSuchAlgorithmException var5_4) {}
            ++n2;
        } while (true);
    }

    abstract byte[] a(String var1);
}

