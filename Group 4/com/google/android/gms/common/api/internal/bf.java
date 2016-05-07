/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ax;
import com.google.android.gms.common.api.internal.bd;
import com.google.android.gms.common.api.t;

final class bf
extends Handler {
    final /* synthetic */ bd a;

    /*
     * Enabled unnecessary exception pruning
     */
    public void handleMessage(Message message) {
        switch (message.what) {
            default: {
                Log.e((String)"TransformedResultImpl", (String)("TransformationResultHandler received unknown message type: " + message.what));
                return;
            }
            case 0: {
                t t2 = (t)message.obj;
                Object object = bd.d(this.a);
                // MONITORENTER : object
                if (t2 == null) {
                    bd.a(bd.e(this.a), new Status(13, "Transform returned null"));
                    // MONITOREXIT : object
                    return;
                }
                if (t2 instanceof ax) {
                    bd.a(bd.e(this.a), ((ax)t2).b());
                    return;
                }
                bd.e(this.a).a(t2);
                return;
            }
            case 1: 
        }
        RuntimeException runtimeException = (RuntimeException)message.obj;
        Log.e((String)"TransformedResultImpl", (String)("Runtime exception on the transformation worker thread: " + runtimeException.getMessage()));
        throw runtimeException;
    }
}

