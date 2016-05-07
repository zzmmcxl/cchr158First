/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.StrictMode;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import java.util.concurrent.Callable;

@fi
public class gv {
    public static Object a(Callable callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            Object v2 = callable.call();
            return v2;
        }
        catch (Throwable var3_3) {
            fp.b("Unexpected exception.", var3_3);
            g.f().a(var3_3, true);
            return null;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }
}

