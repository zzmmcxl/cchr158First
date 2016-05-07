/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.StrictMode;
import java.util.concurrent.Callable;

public class ky {
    public static Object a(Callable callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)StrictMode.ThreadPolicy.LAX);
            Object v2 = callable.call();
            return v2;
        }
        catch (Throwable var3_3) {
            return null;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }
}

