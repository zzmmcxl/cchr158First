/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.e;

import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.e.b;

public final class a {
    public static /* varargs */ AsyncTask a(AsyncTask asyncTask, Object ... arrobject) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            b.a(asyncTask, arrobject);
            return asyncTask;
        }
        asyncTask.execute(arrobject);
        return asyncTask;
    }
}

