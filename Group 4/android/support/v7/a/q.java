/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class q
extends Handler {
    private WeakReference a;

    public q(DialogInterface dialogInterface) {
        this.a = new WeakReference<DialogInterface>(dialogInterface);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            default: {
                return;
            }
            case -3: 
            case -2: 
            case -1: {
                ((DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)this.a.get(), message.what);
                return;
            }
            case 1: 
        }
        ((DialogInterface)message.obj).dismiss();
    }
}

