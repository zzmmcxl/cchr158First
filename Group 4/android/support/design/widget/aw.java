/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;

final class aw
implements Handler.Callback {
    aw() {
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            default: {
                return false;
            }
            case 0: {
                ((Snackbar)message.obj).b();
                return true;
            }
            case 1: 
        }
        ((Snackbar)message.obj).a(message.arg1);
        return true;
    }
}

