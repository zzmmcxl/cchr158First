/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.bj;
import android.support.design.widget.bm;

class bk
implements Handler.Callback {
    final /* synthetic */ bj a;

    bk(bj bj2) {
        this.a = bj2;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            default: {
                return false;
            }
            case 0: 
        }
        bj.a(this.a, (bm)message.obj);
        return true;
    }
}

