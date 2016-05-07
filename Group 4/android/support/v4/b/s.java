/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.support.v4.b.p;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class s
extends FutureTask {
    final /* synthetic */ p a;

    s(p p2, Callable callable) {
        this.a = p2;
        super(callable);
    }

    @Override
    protected void done() {
        try {
            Object v2 = this.get();
            p.b(this.a, v2);
            return;
        }
        catch (InterruptedException var4_2) {
            Log.w((String)"AsyncTask", (Throwable)var4_2);
            return;
        }
        catch (ExecutionException var3_3) {
            throw new RuntimeException("An error occurred while executing doInBackground()", var3_3.getCause());
        }
        catch (CancellationException var2_4) {
            p.b(this.a, null);
            return;
        }
        catch (Throwable var1_5) {
            throw new RuntimeException("An error occurred while executing doInBackground()", var1_5);
        }
    }
}

