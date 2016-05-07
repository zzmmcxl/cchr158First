/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.e;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

class b {
    static /* varargs */ void a(AsyncTask asyncTask, Object ... arrobject) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arrobject);
    }
}

